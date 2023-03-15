package com.gmail.gabow95k.beersoftheworld.base;

import com.gmail.gabow95k.beersoftheworld.R;

import java.net.SocketTimeoutException;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<T> {
    protected T view = null;
    private final CompositeDisposable mCompositeDisposable;

    protected boolean isViewAttached() {
        return view != null;
    }

    public BasePresenter(T view) {
        this.view = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    protected void addSubscription(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    void detachView() {
        mCompositeDisposable.clear();
        this.view = null;
    }

    protected int processError(Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof SocketTimeoutException) {
            return R.string.retrofit_timeout;
        } else {
            return R.string.retrofit_failure;
        }
    }
}
