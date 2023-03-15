package com.gmail.gabow95k.beersoftheworld.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gmail.gabow95k.beersoftheworld.R;
import com.gmail.gabow95k.beersoftheworld.databinding.ActivitySessionBinding;
import com.gmail.gabow95k.beersoftheworld.ui.login.view.LogInFragment;

public class SessionActivity extends AppCompatActivity {

    private ActivitySessionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySessionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentSession, new LogInFragment(), new LogInFragment().getTag())
                .commit();
    }
}