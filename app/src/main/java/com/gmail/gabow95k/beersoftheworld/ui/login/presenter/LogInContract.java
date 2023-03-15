package com.gmail.gabow95k.beersoftheworld.ui.login.presenter;

import com.gmail.gabow95k.beersoftheworld.base.BaseView;

public interface LogInContract {
    interface View extends BaseView {
        void userError(String message);

        void passwordError(String message);

        void success(String message);
    }

    interface Presenter {
        void logIn(String user, String password);
    }

    interface Interactor {
    }
}
