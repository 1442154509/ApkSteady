package com.ui.ApkSteady.http;

import com.hazz.baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.res.BaseResListBean;
import com.ui.ApkSteady.ui.data.res.BasketBallDetailRes;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/Api/CompetitionList")
    Observable<BaseHttpResult<List<MatchConditionBean>>>getMatchList(@Query("sportsId") int type);

    @GET("Index")
    Observable<BaseHttpResult<List<IndexRes>>> getIndex(@Query("sportsId") String sportsId);

    @GET("Detail/Football?")
    Observable<BaseHttpResult<FootBallDetailRes>> getFootBallHistoryDetail(@Query("matchId") String matchId, @Query("sportsId") String sportsId);

    @GET("Detail/Basketball?")
    Observable<BaseHttpResult<BasketBallDetailRes>> getBasketBallHistoryDetail(@Query("matchId") String matchId, @Query("sportsId") String sportsId);
}
