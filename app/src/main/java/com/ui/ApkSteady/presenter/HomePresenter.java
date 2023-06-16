package com.ui.ApkSteady.presenter;

import com.hazz.baselibs.mvp.BasePresenter;
import com.hazz.baselibs.net.BaseHttpResult;
import com.hazz.baselibs.net.BaseObserver2;
import com.hazz.baselibs.rx.RxSchedulers;
import com.ui.ApkSteady.contract.HomeContract;
import com.ui.ApkSteady.model.HomeModel;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import java.util.List;

public class HomePresenter extends BasePresenter<HomeModel, HomeContract.HomeView> {

    @Override
    protected HomeModel createModel() {
        return new HomeModel();
    }

    public void getDataFormModel(int sportsId) {
        getModel().getDataFormModel(String.valueOf(sportsId))
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver2<List<IndexRes>>(getView()) {

                    @Override
                    public void onSuccess(BaseHttpResult<List<IndexRes>> result) {
                        getView().updataUI(result.getData());
                    }

                    @Override
                    public void onFailure(String errMsg, boolean isNetError) {

                    }

                });
    }
}
