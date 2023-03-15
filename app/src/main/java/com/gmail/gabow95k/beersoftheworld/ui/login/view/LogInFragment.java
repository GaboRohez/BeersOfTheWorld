package com.gmail.gabow95k.beersoftheworld.ui.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gmail.gabow95k.beersoftheworld.R;
import com.gmail.gabow95k.beersoftheworld.base.BaseFragment;
import com.gmail.gabow95k.beersoftheworld.constants.Constants;
import com.gmail.gabow95k.beersoftheworld.data.preferences.PreferencesManager;
import com.gmail.gabow95k.beersoftheworld.databinding.FragmentLoginBinding;
import com.gmail.gabow95k.beersoftheworld.ui.DashboardActivity;
import com.gmail.gabow95k.beersoftheworld.ui.login.interactor.LogInInteractor;
import com.gmail.gabow95k.beersoftheworld.ui.login.presenter.LogInContract;
import com.gmail.gabow95k.beersoftheworld.ui.login.presenter.LogInPresenter;
import com.gmail.gabow95k.beersoftheworld.ui.reset_password.view.ResetFragment;
import com.gmail.gabow95k.beersoftheworld.ui.signup.view.SignUpFragment;

public class LogInFragment extends BaseFragment<LogInContract.Presenter, FragmentLoginBinding> implements LogInContract.View {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogInInteractor interactor = new LogInInteractor();
        presenter = new LogInPresenter(requireActivity(), this, interactor);

        if (PreferencesManager.getInstance().getBoolean(Constants.LOGIN_KEY_PREFS)) {
            openDashboard();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpEvents();
    }

    private void setUpEvents() {

        binding.etUser.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty())
                    binding.etUser.setError(null);
            }
        });

        binding.etPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty())
                    binding.etPassword.setError(null);
            }
        });

        binding.btnLogin.setOnClickListener(v ->
                presenter.logIn(
                        binding.etUser.getEditText().getText().toString().trim(),
                        binding.etPassword.getEditText().getText().toString().trim())

        );

        binding.btnRecoverPass.setOnClickListener(v -> addFragment(new ResetFragment(), R.id.contentSession));

        binding.btnGoSignup.setOnClickListener(v -> addFragment(new SignUpFragment(), R.id.contentSession));
    }

    @Override
    public void userError(String message) {
        binding.etUser.setError(message);
    }

    @Override
    public void passwordError(String message) {
        binding.etPassword.setError(message);
    }

    @Override
    public void success(String message) {
        showSuccessSnackBar(binding.getRoot(), message);
        openDashboard();
    }

    private void openDashboard() {
        Intent intent = new Intent(requireActivity(), DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}