package cn.nineox.xframework.base;

import android.app.Activity;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;

import com.yanzhenjie.nohttp.rest.RequestQueue;

import java.util.UUID;

import cn.nineox.xframework.core.common.http.ApiRetrofit;
import cn.nineox.xframework.core.common.http.SubscriberCallBack;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by me on 17/9/27.
 */
public class BaseLogic<DataBinding extends ViewDataBinding> {

    private String baseUrl;


    public Activity mActivity;

    public Fragment mFragment;

    private String TAG = UUID.randomUUID().toString();

    public CompositeSubscription mCompositeSubscription;


    public DataBinding mDataBinding;

    public BaseLogic(DataBinding binding) {
        this.mDataBinding = binding;
    }


    public BaseLogic(Fragment fragment, DataBinding binding) {

        this.mFragment = fragment;
        this.mActivity = fragment.getActivity();
        this.mDataBinding = binding;
    }


    public BaseLogic(Activity activity, DataBinding binding) {
        this.mActivity = activity;
        this.mDataBinding = binding;
    }

    public void addSubscription(Observable observable, SubscriberCallBack subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    public <T> T getRetrofit(Class<T> service) {
        if (mActivity == null) {
            throw new NullPointerException("嘿！mActivity不能为null,仔细检查下吧！");
        } else {
            //这样做的目的让logic设置对应的Api接口
            return (T) ApiRetrofit.getInstance(mActivity).getmApiRetrofit(baseUrl).create(service.getClass());
        }
    }

    //可以设置不同的域名
    public <T> T getRetrofit(Class<T> service, String baseUrl) {
        if (mActivity == null) {
            throw new NullPointerException("嘿！mActivity不能为null,仔细检查下吧！");
        } else {
            //这样做的目的让logic设置对应的Api接口
            return (T) ApiRetrofit.getInstance(mActivity).getmApiRetrofit(baseUrl).create(service.getClass());
        }
    }

}
