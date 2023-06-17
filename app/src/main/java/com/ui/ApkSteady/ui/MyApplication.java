package com.ui.ApkSteady.ui;

import android.app.Application;
import android.content.Context;

import baselibs.app.BaseApplication;


public class MyApplication extends BaseApplication {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
