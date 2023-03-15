package com.gmail.gabow95k.beersoftheworld.ui.signup.presenter;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.gmail.gabow95k.beersoftheworld.app.BeerApp;
import com.gmail.gabow95k.beersoftheworld.base.BasePresenter;
import com.gmail.gabow95k.beersoftheworld.data.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpPresenter extends BasePresenter<SignUpContract.View> implements SignUpContract.Presenter {

    private static final String TAG = "SignUpPresenter";
    private Activity activity;
    private SignUpContract.Interactor interactor;

    public SignUpPresenter(Activity activity, SignUpContract.View view, SignUpContract.Interactor interactor) {
        super(view);
        this.activity = activity;
        this.interactor = interactor;
    }

    @Override
    public void createUser(String username, String email, String password, String confirmPassword) {
        if (username.isEmpty()) {
            view.userNameError(BeerApp.androidResourceManager.getEmptyMessage());
            return;
        }

        if (email.isEmpty()) {
            view.emailError(BeerApp.androidResourceManager.getEmptyMessage());
            return;
        }

        if (password.isEmpty()) {
            view.passwordError(BeerApp.androidResourceManager.getEmptyMessage());
            return;
        }

        if (confirmPassword.isEmpty()) {
            view.confirmPassError(BeerApp.androidResourceManager.getEmptyMessage());
            return;
        }

        if (!password.equals(confirmPassword)) {
            view.showErrorDialog(BeerApp.androidResourceManager.getPasswordNotSame());
            return;
        }

        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, task -> {
                    if (task.isSuccessful()) {
                        saveData(email, username);
                    } else {
                        view.showErrorDialog(BeerApp.androidResourceManager.getCommonError());
                    }
                });
    }

    private void saveData(String email, String username) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("users").child(username);
        User user = new User();
        user.setEmail(email);
        reference.setValue(user);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                view.userCreated(BeerApp.androidResourceManager.getUserCreated());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                view.showErrorDialog(databaseError.getMessage());
            }
        });
    }
}
