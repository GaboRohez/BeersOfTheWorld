package com.gmail.gabow95k.beersoftheworld.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.gmail.gabow95k.beersoftheworld.R;
import com.gmail.gabow95k.beersoftheworld.custom.Loader;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public abstract class BaseFragment<T, B extends ViewBinding> extends Fragment implements BaseView {
    protected T presenter;
    protected B binding;

    private Loader loader;

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
        getLoader().show(requireActivity().getSupportFragmentManager(), Loader.class.getName());
    }

    @Override
    public void hideLoader() {
        getLoader().dismiss();
    }

    @Override
    public void showErrorDialog(String message) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireActivity());
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.accept), (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showErrorDialog(int resourceId) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireActivity());
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(resourceId));
        builder.setPositiveButton(getString(R.string.accept), (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showSuccessSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setBackgroundTint(requireContext().getColor(R.color.colorGreenSuccess)).show();
    }

    private Loader getLoader() {
        if (loader != null)
            return loader;
        else
            return loader = new Loader();
    }
}
