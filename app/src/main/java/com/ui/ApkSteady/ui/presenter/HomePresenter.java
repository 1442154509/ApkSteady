package com.ui.ApkSteady.ui.presenter;

import com.hazz.baselibs.mvp.BasePresenter;
import com.ui.ApkSteady.ui.contract.HomeContract;
import com.ui.ApkSteady.ui.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeModel, HomeContract.HomeView> {

    @Override
    protected HomeModel createModel() {
        return new HomeModel();
    }

    public void getDataFormModel(String sportsId) {
//        getModel().getDataFormModel(sportsId)
//                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
//                .subscribe(new Observer<IndexRes>(getView()) {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(IndexRes r) {
//                        getView().updataUI(r.getData());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
