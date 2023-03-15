package com.gmail.gabow95k.beersoftheworld.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.gmail.gabow95k.beersoftheworld.R;
import com.gmail.gabow95k.beersoftheworld.data.preferences.PreferencesManager;

public class BeerApp extends Application {

    private static Context mContext;
    public static AndroidResourceManager androidResourceManager;

    @Override
    public void onCreate() {
        super.onCreate();
        PreferencesManager.getInstance(this);
        mContext = getApplicationContext();
        androidResourceManager = new AndroidResourceManager(getResources());
    }

    public static Context getAppContext() {
        return mContext;
    }

    public static class AndroidResourceManager {

        private final Resources resources;

        public AndroidResourceManager(Resources resources) {
            this.resources = resources;
        }

        public String getAppName() {
            return resources.getString(R.string.app_name);
        }

        public String getEmptyMessage() {
            return resources.getString(R.string.empty_field);
        }

        public String getPasswordNotSame() {
            return resources.getString(R.string.password_not_same);
        }

        public String getCommonError() {
            return resources.getString(R.string.common_error);
        }

        public String getUserCreated() {
            return resources.getString(R.string.user_created);
        }

        public String getRequestConfirmed() {
            return resources.getString(R.string.request_confirmed);
        }

        public String getInvalidEmail() {
            return resources.getString(R.string.invalid_email);
        }

        public String getInvalidUser() {
            return resources.getString(R.string.invalid_user);
        }

        public String getSuccess() {
            return resources.getString(R.string.success);
        }
    }

}
