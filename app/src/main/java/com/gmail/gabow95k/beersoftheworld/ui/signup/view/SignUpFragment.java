package com.gmail.gabow95k.beersoftheworld.ui.signup.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gmail.gabow95k.beersoftheworld.base.BaseFragment;
import com.gmail.gabow95k.beersoftheworld.databinding.FragmentSignUpBinding;
import com.gmail.gabow95k.beersoftheworld.ui.signup.interactor.SignUpInteractor;
import com.gmail.gabow95k.beersoftheworld.ui.signup.presenter.SignUpContract;
import com.gmail.gabow95k.beersoftheworld.ui.signup.presenter.SignUpPresenter;

public class SignUpFragment extends BaseFragment<SignUpContract.Presenter, FragmentSignUpBinding> implements SignUpContract.View {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SignUpInteractor interactor = new SignUpInteractor();
        presenter = new SignUpPresenter(requireActivity(), this, interactor);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpEvents();
    }

    private void setUpEvents() {
        binding.btnAccept.setOnClickListener(v -> presenter.createUser(
                binding.etUsername.getEditText().getText().toString().trim(),
                binding.etEmail.getEditText().getText().toString().trim(),
                binding.etPass.getEditText().getText().toString().trim(),
                binding.etConfirmPass.getEditText().getText().toString().trim()
        ));

        binding.btnBack.setOnClickListener(v -> popBackStack());

        binding.btnCancel.setOnClickListener(v -> popBackStack());

        binding.etUsername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty())
                    binding.etUsername.setError(null);
            }
        });

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

        binding.etPass.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty())
                    binding.etPass.setError(null);
            }
        });

        binding.etConfirmPass.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty())
                    binding.etConfirmPass.setError(null);
            }
        });
    }

    @Override
    public void userNameError(String message) {
        binding.etUsername.setError(message);
    }

    @Override
    public void emailError(String message) {
        binding.etEmail.setError(message);
    }

    @Override
    public void passwordError(String message) {
        binding.etPass.setError(message);
    }

    @Override
    public void confirmPassError(String message) {
        binding.etConfirmPass.setError(message);
    }

    @Override
    public void userCreated(String message) {
        showSuccessSnackBar(binding.getRoot(), message);
        binding.etUsername.getEditText().setText("");
        binding.etEmail.getEditText().setText("");
        binding.etPass.getEditText().setText("");
        binding.etConfirmPass.getEditText().setText("");
    }
}