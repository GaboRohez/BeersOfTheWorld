package com.gmail.gabow95k.beersoftheworld.ui.login.presenter;

import com.gmail.gabow95k.beersoftheworld.base.BasePresenter;

public class LogInPresenter extends BasePresenter<LogInContract.View> implements LogInContract.Presenter {

    private LogInContract.Interactor interactor;

    public LogInPresenter(LogInContract.View view, LogInContract.Interactor interactor) {
        super(view);
        this.interactor = interactor;
    }

}
