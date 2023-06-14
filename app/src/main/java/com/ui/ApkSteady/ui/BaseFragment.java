package com.ui.ApkSteady.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.ui.ApkSteady.ui.utils.LogUtils;
import com.ui.ApkSteady.ui.utils.VolleyResQue;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    // 1. 本地变量，用于记录状态
    private String mClassName;
    private boolean mResume = false;// 标记onResume是否被刚刚调用

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    //加载布局
    protected abstract int setLayout();

    //初始化数据
    protected abstract void initData();

    // 2. 自定义方法，用于判断fragment真实展现，不要用其提供的isVisible()方法
    public boolean isRealVisible() {
        return getUserVisibleHint() && mResume;
    }

    // 3. demo 打印日志，用于讲解
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtils.i("setUserVisibleHint mClassName=" + mClassName + " isVisibleToUser:" + isVisibleToUser + "\tisVisible:" + isVisible() + "\tisRealVisible:" + isRealVisible());
        if (isVisibleToUser && isVisible() && isRealVisible()) {
            onFragmentVisible();
        } else {
            onFragmentUnVisible();
        }
//        if (!isRealVisible()) {
//            onFragmentUnVisible();
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mClassName = getClass().getSimpleName();
        mResume = true;
        LogUtils.i("onResume  mClassName=" + mClassName + "\tisVisible:" + isVisible() + "\tisRealVisible:" + isRealVisible());
        if (isVisible() && isRealVisible()) {
            onFragmentVisible();
        } else {
            onFragmentUnVisible();
        }
    }

    protected void onFragmentVisible() {
//        timeLooprefesh();

        LogUtils.i("可见");
    }

    protected void onFragmentUnVisible() {
//        timeLoopcancel();
        LogUtils.i("不可见");
        mTimeHandler.removeCallbacks(mTimeCounterRunnable);
    }


    @Override
    public void onStop() {
        super.onStop();
        mResume = false;
        LogUtils.i("onStop  mClassName=" + mClassName + "\tisVisible:" + isVisible() + "\tisRealVisible:" + isRealVisible());
        if (!isRealVisible()) {
            onFragmentUnVisible();
        }
    }

    protected static final int PERIOD = 1 * 1000;
    protected static final int DELAY = 0;
    private Timer mTimer;
    private TimerTask mTimerTask;
    //是否使用定时器
    protected boolean isTimmerUse = true;

    private void timeLoopcancel() {
        if (mTimer != null) {
            mTimer.purge();
            mTimer.cancel();
            mTimer = null;
            LogUtils.e("---t定时器 取消了--");
        }
    }

    protected void timeLooprefesh() {
        LogUtils.e("++++定时器开始++++");
        if (mTimer == null) {
            mTimer = new Timer();
        }

//        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                if (isTimmerUse) {
                    LogUtils.e("$$$$$定时器刷新了$$$$");
                }

//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                        }
//                    });
                //在此添加轮询

            }
        };
        mTimer.schedule(mTimerTask, DELAY, PERIOD);
    }

    private final Handler mTimeHandler = new Handler(Looper.getMainLooper());
    private Runnable mTimeCounterRunnable = new Runnable() {
        @Override
        public void run() {
            //todo
//            Toast.makeText(getActivity(),"刷新了",Toast.LENGTH_SHORT).show();
            LogUtils.e("$$$$$handle刷新了$$$$");
            mTimeHandler.postDelayed(this, 10 * 1000);
        }
    };

    public void meHandler() {
        mTimeHandler.postDelayed(mTimeCounterRunnable, 2000);
    }

    protected <T> void addVolleyResQue(Request<T> req) {
        VolleyResQue.getInstance(MyApplication.getContext()).addToRequestQueue(req);
        //设置标记
        req.setTag(LogUtils.getTag());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ///结束时候取消任务
        VolleyResQue.getInstance(MyApplication.getContext()).cancel(LogUtils.getTag());
    }
}