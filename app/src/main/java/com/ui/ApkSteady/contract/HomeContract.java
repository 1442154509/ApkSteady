package com.ui.ApkSteady.contract;

import baselibs.mvp.IModel;
import baselibs.mvp.IView;
import baselibs.net.BaseHttpResult;
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
