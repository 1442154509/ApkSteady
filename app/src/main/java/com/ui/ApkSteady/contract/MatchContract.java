package com.ui.ApkSteady.contract;

import baselibs.mvp.IModel;
import baselibs.mvp.IView;
import baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.ui.data.MatchConditionBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class MatchContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    public interface View extends IView {
        void onGetMatchLsitSuccess(List<MatchConditionBean> matchList);

        void onGetMatchLsitFail(String msg);
    }

    public interface Model extends IModel {
        Observable<BaseHttpResult<List<MatchConditionBean>>> getMatchList(int type);
    }
}
