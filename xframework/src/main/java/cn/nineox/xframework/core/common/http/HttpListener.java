package cn.nineox.xframework.core.common.http;

public interface HttpListener<T>  {

    void onSucceed(int what, Result<T> t);

    void onFailed(int what,String error);

    void onFinish(int what);

}