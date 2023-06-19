package com.ui.ApkSteady.model;

import baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.contract.MatchContract;
import com.ui.ApkSteady.http.RetrofitUtils;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.req.CompetitionReq;
import com.ui.ApkSteady.ui.data.res.CompetionRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class MatchModel implements MatchContract.Model {
    @Override
    public Observable<BaseHttpResult<List<MatchConditionBean>>> getMatchList(int type) {
        return RetrofitUtils.getHttpService().getMatchList(type);
    }

    @Override
    public Observable<BaseHttpResult<List<MatchConditionBean>>> getCompetitionWithId(CompetitionReq body) {
        return  RetrofitUtils.getHttpService().getCompetitionWithId(body);
    }

    @Override
    public void onDestroy() {

    }
}
