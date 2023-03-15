package com.gmail.gabow95k.beersoftheworld.ui.login.presenter;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.gmail.gabow95k.beersoftheworld.Constants.Constants;
import com.gmail.gabow95k.beersoftheworld.app.BeerApp;
import com.gmail.gabow95k.beersoftheworld.base.BasePresenter;
import com.gmail.gabow95k.beersoftheworld.data.preferences.PreferencesManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInPresenter extends BasePresenter<LogInContract.View> implements LogInContract.Presenter {

    private Activity activity;
    private LogInContract.Interactor interactor;

    public LogInPresenter(Activity activity, LogInContract.View view, LogInContract.Interactor interactor) {
        super(view);
        this.activity = activity;
        this.interactor = interactor;
    }

    @Override
    public void logIn(String user, String password) {

        if (user.isEmpty()) {
            view.userError(BeerApp.androidResourceManager.getEmptyMessage());
            return;
        }

        if (password.isEmpty()) {
            view.passwordError(BeerApp.androidResourceManager.getEmptyMessage());
            return;
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(user);

        view.showLoader();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                view.hideLoader();
                if (snapshot.exists()) {
                    signIn(snapshot.child("email").getValue(String.class), password, user);
                } else {
                    view.showErrorDialog(BeerApp.androidResourceManager.getInvalidUser());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                view.hideLoader();
                view.showErrorDialog(error.getMessage());
            }
        });

    }

    private void signIn(String email, String password, String username) {
        view.showLoader();

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, task -> {
                    view.hideLoader();

                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        PreferencesManager.getInstance().saveBoolean(Constants.LOGIN_KEY_PREFS, true);
                        PreferencesManager.getInstance().saveString(Constants.USER_KEY_PREFS, username);
                        PreferencesManager.getInstance().saveString(Constants.EMAIL_KEY_PREFS, email);
                        PreferencesManager.getInstance().saveString(Constants.UI_KEY_PREFS, user.getUid());

                        view.success(BeerApp.androidResourceManager.getSuccess());
                    } else {

                    }
                }).addOnFailureListener(e -> {
                    view.hideLoader();
                    view.showErrorDialog(e.getMessage());
                });
    }
}
