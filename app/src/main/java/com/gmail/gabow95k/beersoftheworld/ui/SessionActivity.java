package com.gmail.gabow95k.beersoftheworld.ui;

import android.os.Bundle;

import com.gmail.gabow95k.beersoftheworld.R;
import com.gmail.gabow95k.beersoftheworld.base.BaseActivity;
import com.gmail.gabow95k.beersoftheworld.base.BasePresenter;
import com.gmail.gabow95k.beersoftheworld.databinding.ActivitySessionBinding;
import com.gmail.gabow95k.beersoftheworld.ui.login.view.LogInFragment;

public class SessionActivity extends BaseActivity<BasePresenter> {

    private ActivitySessionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySessionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setFragment(new LogInFragment(), R.id.contentSession);
    }
}