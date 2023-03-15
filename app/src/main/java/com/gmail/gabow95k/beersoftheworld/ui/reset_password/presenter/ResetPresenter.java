package com.gmail.gabow95k.beersoftheworld.ui.reset_password.presenter;

import com.gmail.gabow95k.beersoftheworld.app.BeerApp;
import com.gmail.gabow95k.beersoftheworld.base.BasePresenter;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPresenter extends BasePresenter<ResetContract.View> implements ResetContract.Presenter {

    private ResetContract.Interactor interactor;

    public ResetPresenter(ResetContract.View view, ResetContract.Interactor interactor) {
        super(view);
        this.interactor = interactor;
    }


    @Override
    public void changePassword(String email) {

        if (email.isEmpty()) {
            view.emailError(BeerApp.androidResourceManager.getEmptyMessage());
            return;
        }

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        view.showLoader();

        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    view.hideLoader();

                    if (task.isSuccessful()) {
                        view.success(BeerApp.androidResourceManager.getRequestConfirmed());
                    } else {
                        view.showErrorDialog(BeerApp.androidResourceManager.getCommonError());
                    }
                })
                .addOnFailureListener(e -> {
                    view.hideLoader();
                    view.showErrorDialog(e.getMessage());
                });

    }
}
