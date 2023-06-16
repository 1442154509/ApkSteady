package com.ui.ApkSteady.contract;

import com.hazz.baselibs.mvp.IModel;
import com.hazz.baselibs.mvp.IView;
import com.hazz.baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.ui.data.res.FootBallDetailRes;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;


public interface HomeContract {
    interface HomeModel extends IModel {
        Observable<BaseHttpResult<List<IndexRes>>> getDataFormModel(String sportsId);
    }

    interface HomeView extends IView {
        void updataUI(List<IndexRes> result);
    }

}
