package com.ui.ApkSteady.ui.utils;

import android.widget.Toast;

import com.ui.ApkSteady.ui.MyApplication;

public class ToastUtils {
    public static void show(String msg) {
        Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg) {
        Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_LONG).show();
    }
}
