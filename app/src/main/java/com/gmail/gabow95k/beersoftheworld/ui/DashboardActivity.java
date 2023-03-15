package com.gmail.gabow95k.beersoftheworld.ui;

import android.os.Bundle;

import com.gmail.gabow95k.beersoftheworld.R;
import com.gmail.gabow95k.beersoftheworld.base.BaseActivity;
import com.gmail.gabow95k.beersoftheworld.base.BasePresenter;
import com.gmail.gabow95k.beersoftheworld.constants.Constants;
import com.gmail.gabow95k.beersoftheworld.data.preferences.PreferencesManager;
import com.gmail.gabow95k.beersoftheworld.databinding.ActivityDashboardBinding;
import com.gmail.gabow95k.beersoftheworld.ui.beers.view.BeersFragment;

public class DashboardActivity extends BaseActivity<BasePresenter> {

    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvWelcome.setText(String.format(getString(R.string.welcome), PreferencesManager.getInstance().getString(Constants.USER_KEY_PREFS)));
        setFragment(new BeersFragment(), R.id.contentDashboard);
    }
}