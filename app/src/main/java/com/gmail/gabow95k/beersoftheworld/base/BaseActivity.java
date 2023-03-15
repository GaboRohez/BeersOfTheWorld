package com.gmail.gabow95k.beersoftheworld.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BaseActivity<P> extends AppCompatActivity {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void addFragment(Fragment fragment, int id) {
        getSupportFragmentManager().beginTransaction()
                .add(id, fragment, fragment.getTag())
                .addToBackStack(fragment.getClass().getName())
                .commitAllowingStateLoss();
    }

    protected void setFragment(Fragment fragment, int id) {
        getSupportFragmentManager().beginTransaction()
                .replace(id, fragment, fragment.getClass().getName())
                .commit();
    }

    protected void popBackStack() {
        getSupportFragmentManager().popBackStack();
    }
}
