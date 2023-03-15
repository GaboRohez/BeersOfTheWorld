package com.gmail.gabow95k.beersoftheworld.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.gmail.gabow95k.beersoftheworld.R;
import com.google.android.material.snackbar.Snackbar;

public abstract class BaseFragment<T, B extends ViewBinding> extends Fragment implements BaseView {
    protected T presenter;
    protected B binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    protected void addFragment(Fragment fragment, int id) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity<?>) getActivity()).addFragment(fragment, id);
        }
    }

    protected void popBackStack() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity<?>) getActivity()).popBackStack();
        }
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

    public void showSuccessSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setBackgroundTint(requireContext().getColor(R.color.colorGreenSuccess)).show();
    }
}
