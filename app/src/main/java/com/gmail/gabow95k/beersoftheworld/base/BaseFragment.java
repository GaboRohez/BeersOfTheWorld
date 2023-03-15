package com.gmail.gabow95k.beersoftheworld.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<T, B extends ViewBinding> extends Fragment implements BaseView {
    protected T presenter;
    protected B binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    protected void addFragment(Fragment fragment, int id) {
        getChildFragmentManager().beginTransaction()
                .add(id, fragment, fragment.getTag())
                .addToBackStack(fragment.getTag())
                .commitAllowingStateLoss();
    }

    protected void setFragment(Fragment fragment, int id) {
        getChildFragmentManager().beginTransaction()
                .replace(id, fragment, fragment.getTag())
                .commit();
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public void showErrorDialog(String message) {

    }

    @Override
    public void showErrorDialog(int resourceId) {

    }
}
