package com.ui.ApkSteady.ui.data.req;

import com.ui.ApkSteady.ui.data.res.IndexRes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IndexReq {
    @GET("Index")
    Call<IndexRes> getIndex(@Query("sportsId") String sportsId);
}
