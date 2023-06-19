package com.ui.ApkSteady.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ui.ApkSteady.R;
import com.ui.ApkSteady.contract.DisscussContract;
import com.ui.ApkSteady.presenter.DiscusssPresenter;

import baselibs.base.BaseFragment;

public class DiscussFragment extends BaseFragment<DiscusssPresenter> implements DisscussContract.DisscussView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discuss, container, false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discuss;
    }

    @Override
    protected DiscusssPresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean useEventBus() {
        return false;
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void updataUI() {

    }
}