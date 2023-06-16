package com.ui.ApkSteady.ui.contract;

import com.hazz.baselibs.mvp.IModel;
import com.hazz.baselibs.mvp.IView;
import com.ui.ApkSteady.ui.data.res.IndexRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;


public interface HomeContract {
    interface HomeModel extends IModel {
        Observable<IndexRes> getDataFormModel(String sportsId);
    }

    interface HomeView extends IView {
        void updataUI(List<IndexRes.DataDTO> data);
    }

}
