package com.ui.ApkSteady.contract;

import baselibs.mvp.IModel;
import baselibs.mvp.IView;
import baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.ui.data.DetailHistoryEntity;
import com.ui.ApkSteady.ui.data.req.CompetitionReq;
import com.ui.ApkSteady.ui.data.res.BasketBallDetailRes;
import com.ui.ApkSteady.ui.data.res.CompetionRes;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;


public interface DetailHistoryContract {
    interface DetailHistoryModel extends IModel {
        Observable<BaseHttpResult<FootBallDetailRes>> getFootBallHistoryDetail(String matchId, String sportsId);

        Observable<BaseHttpResult<BasketBallDetailRes>> getBasketBallHistoryDetail(String matchId, String sportsId);
        Observable<BaseHttpResult<List<CompetionRes>>> getCompetition(RequestBody body);
    }

    interface DetailHistoryView extends IView {
        void upataFootBallUI(List<DetailHistoryEntity> data);

        void updataBasketBallUI(List<DetailHistoryEntity> data);
    }

}
