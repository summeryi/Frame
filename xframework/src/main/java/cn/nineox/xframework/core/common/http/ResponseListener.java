package cn.nineox.xframework.core.common.http;

/**
 * Created by me on 17/9/28.
 */

public class ResponseListener<T> implements HttpListener<T>  {


    @Override
    public void onSucceed(int what, Result<T> result) {
    }

    @Override
    public void onFailed(int what,String error) {

    }

    @Override
    public void onFinish(int what) {

    }
}
