package com.ui.ApkSteady.http;

import com.hazz.baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.res.BaseResBean;
import com.ui.ApkSteady.ui.data.res.BaseResListBean;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import io.reactivex.Observable;
import retrofit2.Call;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/Api/CompetitionList")
    Observable<BaseResListBean<MatchConditionBean>> getMatchList();

    @GET("Index")
    Observable<IndexRes> getIndex(@Query("sportsId") String sportsId);
    Observable<BaseHttpResult<List<MatchConditionBean>>> getMatchList();
}
