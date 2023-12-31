package com.ui.ApkSteady.model;

import baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.contract.DetailHistoryContract;
import com.ui.ApkSteady.http.RetrofitUtils;
import com.ui.ApkSteady.ui.data.req.CompetitionReq;
import com.ui.ApkSteady.ui.data.res.BasketBallDetailRes;
import com.ui.ApkSteady.ui.data.res.CompetionRes;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;


public class DetailHistoryModel implements DetailHistoryContract.DetailHistoryModel {
    @Override
    public void onDestroy() {

    }

    @Override
    public Observable<BaseHttpResult<FootBallDetailRes>> getFootBallHistoryDetail(String matchId, String sportsId) {
        return RetrofitUtils.getHttpService().getFootBallHistoryDetail(matchId, sportsId);
    }

    @Override
    public Observable<BaseHttpResult<BasketBallDetailRes>> getBasketBallHistoryDetail(String matchId, String sportsId) {
        return RetrofitUtils.getHttpService().getBasketBallHistoryDetail(matchId, sportsId);
    }

    @Override
    public Observable<BaseHttpResult<List<CompetionRes>>> getCompetition(CompetitionReq body) {
        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"matchId\": [\r\n    \"3727557\"],\r\n  \"sportsId\": 1\r\n}");

//        return RetrofitUtils.getHttpService().getCompetition(body);
//        return RetrofitUtils.getHttpService().getCompetition(body.getMatchId(),body.getSportsId());
//        return RetrofitUtils.getHttpService().getCompetition(body);
        return null;
    }
}
