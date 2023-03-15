package com.gmail.gabow95k.beersoftheworld.ui.login.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gmail.gabow95k.beersoftheworld.R;
import com.gmail.gabow95k.beersoftheworld.base.BaseFragment;
import com.gmail.gabow95k.beersoftheworld.databinding.FragmentLoginBinding;
import com.gmail.gabow95k.beersoftheworld.ui.login.interactor.LogInInteractor;
import com.gmail.gabow95k.beersoftheworld.ui.login.presenter.LogInContract;
import com.gmail.gabow95k.beersoftheworld.ui.login.presenter.LogInPresenter;
import com.gmail.gabow95k.beersoftheworld.ui.signup.view.SignUpFragment;

public class LogInFragment extends BaseFragment<LogInContract.Presenter, FragmentLoginBinding> implements LogInContract.View {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogInInteractor interactor = new LogInInteractor();
        presenter = new LogInPresenter(this, interactor);
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
        binding.btnGoSignup.setOnClickListener(v -> addFragment(new SignUpFragment(), R.id.contentSession));
    }
}