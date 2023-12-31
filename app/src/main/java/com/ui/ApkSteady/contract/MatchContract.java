package com.ui.ApkSteady.contract;

import baselibs.mvp.IModel;
import baselibs.mvp.IView;
import baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.req.CompetitionReq;
import com.ui.ApkSteady.ui.data.res.CompetionRes;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;

public class MatchContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    public interface View extends IView {
        void onGetMatchLsitSuccess(List<MatchConditionBean> matchList);

        void onGetMatchLsitFail(String msg);
    }

    public interface Model extends IModel {
        /**
         * 获取赛事列表
         * @param type 赛事类型：0全部，1足球，2篮球
         */
        Observable<BaseHttpResult<List<MatchConditionBean>>> getMatchList(int type);
        /**
         * 根据ID获取赛事列表
         * @param body
         */
        Observable<BaseHttpResult<List<MatchConditionBean>>> getCompetitionWithId(@Body CompetitionReq body);
    }
}
