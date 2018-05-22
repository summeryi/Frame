package cn.nineox.xframework.core.common.http;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.error.NetworkError;
import com.yanzhenjie.nohttp.error.NotFoundCacheError;
import com.yanzhenjie.nohttp.error.TimeoutError;
import com.yanzhenjie.nohttp.error.URLError;
import com.yanzhenjie.nohttp.error.UnKnownHostError;

import cn.nineox.xframework.R;
import cn.nineox.xframework.core.android.log.Log;
import cn.nineox.xframework.core.common.assist.Network;
import cn.nineox.xframework.core.common.basebeen.BaseResponse;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/11/14.
 */

public abstract class SubscriberCallBack<T> extends Subscriber<BaseResponse<T>> {

    private Context mContext;
    private ILogin iLogin;

    public void setData(Context context, ILogin iLogin) {
        this.mContext = context;
        this.iLogin = iLogin;
    }

    public interface ILogin {

        // 其他地方登陆了
        public void onLoginError();

        // 网络错误
        public void onNetWorkError();

        //其他错误
        public void otherkError(ExceptionHandle.ResponeThrowable responeThrowable);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("onStart()");
        //接下来可以检查网络连接等操作
        if (!Network.isAvailable(mContext)) {
            iLogin.onNetWorkError();
            // 一定好主动调用下面这一句,取消本次Subscriber订阅
            if (!isUnsubscribed()) {
                unsubscribe();
            }
            return;
        }
    }


    @Override
    public void onNext(BaseResponse<T> tBaseResponse) {
        Log.d("服务器返回" + tBaseResponse);
        switch (tBaseResponse.getCode()) {
            case BaseResponse.RESULT_CODE_SUCCESS:
                onSuccess(tBaseResponse.getData());
                onSuccess(tBaseResponse);
                break;
            case BaseResponse.RESULT_CODE_TOKEN_EXPIRED:
                iLogin.onLoginError();
            default:
                Log.i("DataFailure" + tBaseResponse.toString());
        }
    }

    @Override
    public void onCompleted() {
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        Log.i("onError.throwable =" + e.toString());
        Log.i("onError.throwable =" + e.getMessage());
        if (e instanceof Exception) {
            //访问获得对应的Exception
            onError(ExceptionHandle.handleException(e));
        } else {
            //将Throwable 和 未知错误的status code返回
            onError(new ExceptionHandle.ResponeThrowable(e, ExceptionHandle.ERROR.UNKNOWN));
        }

    }

    protected abstract void onSuccess(T response);

    protected void onError(ExceptionHandle.ResponeThrowable responeThrowable) {
        iLogin.otherkError(responeThrowable);
    }

    //用到finish 可以调用
    protected void onFinish() {
        Log.i("finish");
    }

    //直播获取yeyedata
    protected void onSuccess(BaseResponse<T> response) {

    }

}


