package com.ui.ApkSteady.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;
import com.ui.ApkSteady.R;
//activity基类
public class BaseCommonActivity extends AppCompatActivity {
    public boolean darkStatusBar = true;//当是沉浸式状态栏时，状态栏字体是否黑色字体，false时表示白色字体，true表示黑色字体
    boolean immersionModel = true;//是否是沉浸式状态栏，true时表示是沉浸式
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_common);
        //沉浸状态栏代码
        if (!immersionModel) {
            ImmersionBar.with(this).statusBarColor(R.color.white).statusBarDarkFont(true).fitsSystemWindows(true).init();
        } else {
            if (darkStatusBar) {
                ImmersionBar.with(this).statusBarDarkFont(true).init();
            } else {
                ImmersionBar.with(this).init();
            }
        }
    }
}