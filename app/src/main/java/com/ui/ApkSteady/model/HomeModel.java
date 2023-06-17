package com.ui.ApkSteady.model;

import baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.http.RetrofitUtils;
import com.ui.ApkSteady.contract.HomeContract;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;


public class HomeModel implements HomeContract.HomeModel {
    @Override
    public Observable<BaseHttpResult<List<IndexRes>>> getDataFormModel(String sportsId) {
        return RetrofitUtils.getHttpService().getIndex(sportsId);
    }

    @Override
    public void onDestroy() {

    }
}
