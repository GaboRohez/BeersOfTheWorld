package com.gmail.gabow95k.beersoftheworld.base;

public interface BaseView {
    void showLoader();

    void hideLoader();

    void showErrorDialog(String message);

    void showErrorDialog(int resourceId);
}
