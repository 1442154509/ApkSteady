package com.ui.ApkSteady.ui.model;

import com.ui.ApkSteady.http.RetrofitUtils;
import com.ui.ApkSteady.ui.contract.HomeContract;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import io.reactivex.Observable;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HomeModel implements HomeContract.HomeModel {
    @Override
    public Observable<IndexRes> getDataFormModel(String sportsId) {
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
//        Request request = new Request.Builder()
//                .url("http://34.80.205.147:12300/Api/Index?sportsId=0")
//                .method("GET", body)
//                .build();
//        client.newCall(request).enqueue(callback);
        return RetrofitUtils.getHttpService().getIndex(sportsId);
    }

    @Override
    public void onDestroy() {

    }
}
