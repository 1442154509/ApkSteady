package baselibs.net;


import android.accounts.NetworkErrorException;

import baselibs.mvp.IView;
import baselibs.net.exception.ServerException;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @author xuhao
 * @date 2018/6/12 10:51
 * @desc Observer基类
 */
public abstract class BaseObserver2<T> implements Observer<BaseHttpResult<T>> {

    private IView mView;

    private boolean isShowDialog = true;

    public BaseObserver2(IView mView) {
        this.mView = mView;
    }

    public BaseObserver2(IView mView, boolean isShowDialog) {
        this.mView = mView;
        this.isShowDialog = isShowDialog;
    }

    @Override
    public void onSubscribe(Disposable d) {
        showLoadingDialog();
    }

    @Override
    public void onNext(BaseHttpResult<T> result) {
        hideLoadingDialog();
        if (result.getCode()==200) {
            onSuccess(result);
        } else {
            //TODO API异常处理
            onFailure(result.getMsg(), false);
        }
    }

    @Override
    public void onError(Throwable e) {
        hideLoadingDialog();
        if (e instanceof ConnectException
                || e instanceof TimeoutException
                || e instanceof NetworkErrorException
                || e instanceof UnknownHostException) {
            onFailure(ServerException.handleException(e).getMessage(), true);
        } else {
            onFailure(ServerException.handleException(e).getMessage(), false);
        }
    }

    /**
     * * 请求成功了才会调用 onComplete
     * onError 时不会调用
     */
    @Override
    public void onComplete() {
        hideLoadingDialog();
    }


    /**
     * 请求成功返回
     *
     * @param result 服务器返回数据
     */
    public abstract void onSuccess(BaseHttpResult<T> result);

    /**
     * 请求失败返回
     *
     * @param errMsg     失败信息
     * @param isNetError 是否是网络异常
     */
    public abstract void onFailure(String errMsg, boolean isNetError);


    /**
     * 显示 LoadingDialog
     */
    private void showLoadingDialog() {
        if (isShowDialog && mView != null) {
            mView.showLoading();
        }
    }

    /**
     * 隐藏 Loading
     */
    private void hideLoadingDialog() {
        if (isShowDialog && mView != null) {
            mView.hideLoading();
        }
    }

}
