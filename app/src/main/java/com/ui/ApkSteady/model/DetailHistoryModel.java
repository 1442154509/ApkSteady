package com.ui.ApkSteady.model;

import com.hazz.baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.contract.DetailHistoryContract;
import com.ui.ApkSteady.http.RetrofitUtils;
import com.ui.ApkSteady.ui.data.res.BasketBallDetailRes;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;


public class DetailHistoryModel implements DetailHistoryContract.DetailHistoryModel {
    @Override
    public void onDestroy() {

    }

    @Override
    public Observable<BaseHttpResult<List<FootBallDetailRes>>> getFootBallHistoryDetail(String matchId, String sportsId) {
        return RetrofitUtils.getHttpService().getFootBallHistoryDetail(matchId, sportsId);
    }

    @Override
    public Observable<BaseHttpResult<List<BasketBallDetailRes>>> getBasketBallHistoryDetail(String matchId, String sportsId) {
        return RetrofitUtils.getHttpService().getBasketBallHistoryDetail(matchId, sportsId);
    }
}
