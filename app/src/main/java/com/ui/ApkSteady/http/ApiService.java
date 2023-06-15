package com.ui.ApkSteady.http;

import com.hazz.baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.res.BaseResBean;
import com.ui.ApkSteady.ui.data.res.BaseResListBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/Api/CompetitionList")
    Observable<BaseHttpResult<List<MatchConditionBean>>> getMatchList();
}
