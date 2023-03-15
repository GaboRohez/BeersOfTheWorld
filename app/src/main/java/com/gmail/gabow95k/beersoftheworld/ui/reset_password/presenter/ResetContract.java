package com.gmail.gabow95k.beersoftheworld.ui.reset_password.presenter;

import com.gmail.gabow95k.beersoftheworld.base.BaseView;

public interface ResetContract {
    interface View extends BaseView {
        void success(String message);

        void emailError(String message);
    }

    interface Presenter {
        void changePassword(String email);
    }

    interface Interactor {
    }
}
