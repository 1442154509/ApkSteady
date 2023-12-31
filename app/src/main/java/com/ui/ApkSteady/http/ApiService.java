package com.ui.ApkSteady.http;

import baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.req.CompetitionReq;
import com.ui.ApkSteady.ui.data.res.BasketBallDetailRes;
import com.ui.ApkSteady.ui.data.res.CompetionRes;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    /**
     * 获取赛事列表
     * @param type 赛事类型：0全部，1足球，2篮球
     */
    @GET("CompetitionList")
    Observable<BaseHttpResult<List<MatchConditionBean>>> getMatchList(@Query("sportsId") int type);


    @GET("Index")
    Observable<BaseHttpResult<List<IndexRes>>> getIndex(@Query("sportsId") String sportsId);

    @GET("Detail/Football?")
    Observable<BaseHttpResult<FootBallDetailRes>> getFootBallHistoryDetail(@Query("matchId") String matchId, @Query("sportsId") String sportsId);

    @GET("Detail/Basketball?")
    Observable<BaseHttpResult<BasketBallDetailRes>> getBasketBallHistoryDetail(@Query("matchId") String matchId, @Query("sportsId") String sportsId);

    /**
     * 根据ID获取赛事列表
     * @param body
     */
    @POST("Competition")
    Observable<BaseHttpResult<List<MatchConditionBean>>> getCompetitionWithId(@Body CompetitionReq body);
}
