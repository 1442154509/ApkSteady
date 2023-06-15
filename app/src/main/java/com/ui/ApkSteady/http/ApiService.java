package com.ui.ApkSteady.http;

import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.res.BaseResListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/Api/CompetitionList")
    Observable<BaseResListBean<MatchConditionBean>> getMatchList();
}
