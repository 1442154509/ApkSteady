package com.ui.ApkSteady.presenter;

import com.ui.ApkSteady.contract.DisscussContract;
import com.ui.ApkSteady.model.DisscussModel;

import baselibs.mvp.BasePresenter;

public class DiscusssPresenter extends BasePresenter<DisscussModel, DisscussContract.DisscussView> {
    @Override
    protected DisscussModel createModel() {
        return new DisscussModel();
    }

    public void getDataFormModel() {
        getView().updataUI();
    }
}
