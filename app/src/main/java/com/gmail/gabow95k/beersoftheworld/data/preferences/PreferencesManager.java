package com.gmail.gabow95k.beersoftheworld.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.gmail.gabow95k.beersoftheworld.constants.Constants;

public class PreferencesManager {

    private static volatile PreferencesManager INSTANCE = null;
    private final SharedPreferences sharedPreferences;
    private static final String PREFERENCES_NAME = Constants.PREFERENCES_NAME;

    private PreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static PreferencesManager getInstance() {
        return INSTANCE;
    }

    public static PreferencesManager getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (PreferencesManager.class) {

                if (INSTANCE == null) {
                    INSTANCE = new PreferencesManager(context);
                }
            }
        }
        return INSTANCE;
    }

    public void saveString(String key, String value) {
        sharedPreferences.edit()
                .putString(key, value)
                .apply();
    }

    public void saveBoolean(String key, Boolean value) {
        sharedPreferences.edit()
                .putBoolean(key, value)
                .apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void removePreferences() {
        sharedPreferences.edit().clear().apply();
    }

}
