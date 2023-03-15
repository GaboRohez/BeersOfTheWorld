package com.gmail.gabow95k.beersoftheworld.ui.signup.presenter;

import com.gmail.gabow95k.beersoftheworld.base.BaseView;

public interface SignUpContract {
    interface View extends BaseView {
        void userNameError(String message);

        void emailError(String message);

        void passwordError(String message);

        void confirmPassError(String message);

        void userCreated(String message);
    }

    interface Presenter {
        void createUser(String username, String email, String password, String confirmPassword);
    }

    interface Interactor {

    }
}
