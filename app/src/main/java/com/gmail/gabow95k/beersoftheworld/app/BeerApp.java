package com.gmail.gabow95k.beersoftheworld.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.gmail.gabow95k.beersoftheworld.R;

public class BeerApp extends Application {

    private static Context mContext;
    public static AndroidResourceManager androidResourceManager;

    @Override
    public void onCreate() {
        super.onCreate();
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
    }

}
