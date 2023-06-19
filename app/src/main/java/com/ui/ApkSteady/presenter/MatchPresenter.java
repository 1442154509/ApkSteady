package com.ui.ApkSteady.presenter;

import android.util.Log;

import baselibs.mvp.BasePresenter;
import baselibs.net.BaseHttpResult;
import baselibs.net.BaseObserver;
import baselibs.net.BaseObserver2;
import baselibs.net.BaseResBean;
import baselibs.rx.RxSchedulers;
import com.ui.ApkSteady.contract.MatchContract;
import com.ui.ApkSteady.model.MatchModel;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.utils.ToastUtils;

import java.util.List;


public class MatchPresenter extends BasePresenter<MatchModel, MatchContract.View> {

    @Override
    protected MatchModel createModel() {
        return new MatchModel();
    }

    public void getMatchList(int type,boolean isShowLoading){
        getModel().getMatchList(type)
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver2<List<MatchConditionBean>>(getView(),isShowLoading) {
                    @Override
                    public void onSuccess(BaseHttpResult<List<MatchConditionBean>> result) {
                        getView().onGetMatchLsitSuccess(result.getData());
                    }

                    @Override
                    public void onFailure(String errMsg, boolean isNetError) {
                        getView().onGetMatchLsitFail(errMsg);
                    }
                });
    }
}
