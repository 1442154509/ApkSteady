package com.ui.ApkSteady.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.gyf.immersionbar.ImmersionBar;
import com.hazz.baselibs.base.BaseActivity;
import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.utils.LogUtils;
import com.ui.ApkSteady.ui.utils.VolleyResQue;

import butterknife.ButterKnife;

//activity基类
public abstract class BaseCommonActivity extends BaseActivity {
    public boolean darkStatusBar = true;//当是沉浸式状态栏时，状态栏字体是否黑色字体，false时表示白色字体，true表示黑色字体
    boolean immersionModel = true;//是否是沉浸式状态栏，true时表示是沉浸式
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base_common);
        ButterKnife.bind(this);
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
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TAG = getClass().getSimpleName();
    }

    protected <T> void addVolleyResQue(Request<T> req) {
        VolleyResQue.getInstance(MyApplication.getContext()).addToRequestQueue(req);
        //设置标记
        req.setTag(LogUtils.getTag());
    }

    @Override
    protected void onStop() {
        super.onStop();
        ///结束时候取消任务
        VolleyResQue.getInstance(MyApplication.getContext()).cancel(LogUtils.getTag());
    }
}