package com.gmail.gabow95k.beersoftheworld.ui.signup.interactor;

import com.gmail.gabow95k.beersoftheworld.ui.signup.presenter.SignUpContract;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpInteractor implements SignUpContract.Interactor {

    private FirebaseAuth auth;

    public SignUpInteractor() {
        this.auth = auth;
    }
}
