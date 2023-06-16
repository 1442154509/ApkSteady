package com.ui.ApkSteady.contract;

import com.hazz.baselibs.mvp.IModel;
import com.hazz.baselibs.mvp.IView;
import com.hazz.baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.ui.data.DetailHistoryEntity;
import com.ui.ApkSteady.ui.data.res.BasketBallDetailRes;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;


public interface DetailHistoryContract {
    interface DetailHistoryModel extends IModel {
        Observable<BaseHttpResult<List<FootBallDetailRes>>> getFootBallHistoryDetail(String matchId, String sportsId);

        Observable<BaseHttpResult<List<BasketBallDetailRes>>> getBasketBallHistoryDetail(String matchId, String sportsId);
    }

    interface DetailHistoryView extends IView {
        void upataFootBallUI(List<DetailHistoryEntity> data);

        void updataBasketBallUI(List<DetailHistoryEntity> data);
    }

}
