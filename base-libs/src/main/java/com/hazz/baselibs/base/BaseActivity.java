package com.hazz.baselibs.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;


import com.gyf.immersionbar.ImmersionBar;
import com.hazz.baselibs.R;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author xuhao
 * @date 2018/6/9 17:12
 * @desc 基类 BaseMvpActivity
 */
public abstract class BaseActivity extends RxAppCompatActivity {
    private Unbinder unBinder;

    private ProgressDialog loadingDialog = null;
    public boolean darkStatusBar = true;//当是沉浸式状态栏时，状态栏字体是否黑色字体，false时表示白色字体，true表示黑色字体
    boolean immersionModel = true;//是否是沉浸式状态栏，true时表示是沉浸式
    private String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        setContentView(getLayoutId());
        Intent intent = getIntent();
        if (intent != null)
            getIntent(intent);
        ButterKnife.bind(this);
        unBinder = ButterKnife.bind(this);
        //沉浸状态栏代码
        if (!immersionModel) {
            ImmersionBar.with(this).statusBarColor("#FFFFFFFF").statusBarDarkFont(true).fitsSystemWindows(true).init();
        } else {
            if (darkStatusBar) {
                ImmersionBar.with(this).statusBarDarkFont(true).init();
            } else {
                ImmersionBar.with(this).init();
            }
        }
        if (useEventBus()) {
            EventBus.getDefault().register(this);//注册eventBus
        }
        initView();
        initData();
        initListener();
    }


    /**
     * 是否使用eventBus
     *
     * @return
     */
    protected boolean useEventBus() {
        return false;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
        if (useEventBus()) {
            if (EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().unregister(this);//注销eventBus
            }
        }

    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 显示带消息的进度框
     *
     * @param title 提示
     */
    protected void showLoadingDialog(String title) {
        createLoadingDialog();
        loadingDialog.setMessage(title);
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    /**
     * 显示进度框
     */
    protected void showLoadingDialog() {
        createLoadingDialog();
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    /**
     * 创建LoadingDialog
     */
    private void createLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new ProgressDialog(this);
            loadingDialog.setCancelable(true);
            loadingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /**
     * 隐藏进度框
     */
    protected void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }


    /**
     * 获取布局 Id
     *
     * @return
     */
    protected abstract @LayoutRes int getLayoutId();

    /**
     * 获取 Intent 数据
     **/
    protected abstract void getIntent(Intent intent);

    /**
     * 初始化View的代码写在这个方法中
     */
    protected abstract void initView();

    /**
     * 初始化监听器的代码写在这个方法中
     */
    protected abstract void initListener();

    /**
     * 初始数据的代码写在这个方法中，用于从服务器获取数据
     */
    protected abstract void initData();


}
