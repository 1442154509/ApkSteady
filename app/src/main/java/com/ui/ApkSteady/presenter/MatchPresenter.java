package com.ui.ApkSteady.presenter;

import android.util.Log;

import com.hazz.baselibs.mvp.BasePresenter;
import com.hazz.baselibs.net.BaseHttpResult;
import com.hazz.baselibs.net.BaseObserver;
import com.hazz.baselibs.net.BaseObserver2;
import com.hazz.baselibs.net.BaseResBean;
import com.hazz.baselibs.rx.RxSchedulers;
import com.ui.ApkSteady.contract.MatchContract;
import com.ui.ApkSteady.model.MatchModel;
import com.ui.ApkSteady.ui.data.MatchConditionBean;

import java.util.List;


public class MatchPresenter extends BasePresenter<MatchModel, MatchContract.View> {

    @Override
    protected MatchModel createModel() {
        return new MatchModel();
    }

    public void getMatchList(){
        getModel().getMatchList()
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver2<List<MatchConditionBean>>(getView()) {
                    @Override
                    public void onSuccess(BaseHttpResult<List<MatchConditionBean>> result) {
                        Log.e("数据",result.getCode()+" ");
                    }

                    @Override
                    public void onFailure(String errMsg, boolean isNetError) {

                    }
                });
    }
}
