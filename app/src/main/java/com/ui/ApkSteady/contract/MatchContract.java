package com.ui.ApkSteady.contract;

import com.hazz.baselibs.mvp.IModel;
import com.hazz.baselibs.mvp.IView;
import com.hazz.baselibs.net.BaseHttpResult;
import com.ui.ApkSteady.ui.data.MatchConditionBean;
import com.ui.ApkSteady.ui.data.res.BaseResBean;
import com.ui.ApkSteady.ui.data.res.BaseResListBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class MatchContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    public interface View extends IView {

    }

    public interface Model extends IModel {
        Observable<BaseHttpResult<List<MatchConditionBean>>> getMatchList();
    }
}