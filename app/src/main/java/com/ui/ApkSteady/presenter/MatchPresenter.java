package com.ui.ApkSteady.presenter;

import android.util.Log;

import baselibs.mvp.BasePresenter;
import baselibs.net.BaseHttpResult;
import baselibs.net.BaseObserver;
import baselibs.net.BaseObserver2;
import baselibs.net.BaseResBean;
import baselibs.rx.RxSchedulers;
import com.ui.ApkSteady.contract.MatchContract;
import com.ui.ApkSteady.model.MatchModel;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.req.CompetitionReq;
import com.ui.ApkSteady.ui.utils.ToastUtils;

import java.util.List;


public class MatchPresenter extends BasePresenter<MatchModel, MatchContract.View> {

    @Override
    protected MatchModel createModel() {
        return new MatchModel();
    }

    /**
     * 获取赛事列表
     * @param type 赛事类型：0全部，1足球，2篮球
     * @param isShowLoading 是否显示loading
     */
    public void getMatchList(int type,boolean isShowLoading){
        getModel().getMatchList(type)
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver2<List<MatchConditionBean>>(getView(),isShowLoading) {
                    @Override
                    public void onSuccess(BaseHttpResult<List<MatchConditionBean>> result) {
                        getView().onGetMatchLsitSuccess(result.getData());
                    }

                    @Override
                    public void onFailure(String errMsg, boolean isNetError) {
                        getView().onGetMatchLsitFail(errMsg);
                    }
                });
    }

    /**
     * 根据ID获取赛事列表
     */
    public void getCompetitionWithId(CompetitionReq competitionReq,boolean isShowLoading){
        getModel().getCompetitionWithId(competitionReq)
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver2<List<MatchConditionBean>>(getView(),isShowLoading) {
                    @Override
                    public void onSuccess(BaseHttpResult<List<MatchConditionBean>> result) {
                        getView().onGetMatchLsitSuccess(result.getData());
                    }

                    @Override
                    public void onFailure(String errMsg, boolean isNetError) {
                        getView().onGetMatchLsitFail(errMsg);
                    }
                });
    }
}
