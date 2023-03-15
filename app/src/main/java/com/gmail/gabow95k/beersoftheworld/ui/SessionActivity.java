package com.gmail.gabow95k.beersoftheworld.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gmail.gabow95k.beersoftheworld.R;

public class SessionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentSession, new LogInFragment(), new LogInFragment().getTag())
                .commit();
    }
}