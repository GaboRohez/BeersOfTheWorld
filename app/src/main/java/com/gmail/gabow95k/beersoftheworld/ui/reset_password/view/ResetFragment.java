package com.gmail.gabow95k.beersoftheworld.ui.reset_password.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gmail.gabow95k.beersoftheworld.base.BaseFragment;
import com.gmail.gabow95k.beersoftheworld.databinding.FragmentResetBinding;
import com.gmail.gabow95k.beersoftheworld.ui.reset_password.interactor.ResetInteractor;
import com.gmail.gabow95k.beersoftheworld.ui.reset_password.presenter.ResetContract;
import com.gmail.gabow95k.beersoftheworld.ui.reset_password.presenter.ResetPresenter;

public class ResetFragment extends BaseFragment<ResetContract.Presenter, FragmentResetBinding> implements ResetContract.View {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResetInteractor interactor = new ResetInteractor();
        presenter = new ResetPresenter(this, interactor);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentResetBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpEvents();
    }

    private void setUpEvents() {
        binding.etEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty())
                    binding.etEmail.setError(null);
            }
        });

        binding.btnSend.setOnClickListener(v -> presenter.changePassword(binding.etEmail.getEditText().getText().toString().trim()));
    }

    @Override
    public void emailError(String message) {
        binding.etEmail.setError(message);
    }

    @Override
    public void success(String message) {
        showSuccessSnackBar(binding.getRoot(), message);
        binding.etEmail.getEditText().setText("");
    }
}