package com.woman.beautylive.commom.basic;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

import com.woman.beautylive.R;
import com.woman.beautylive.ui.root.LoginSelectActivity;

import cn.nineox.xframework.base.BaseLogic;
import cn.nineox.xframework.core.common.http.ExceptionHandle;
import cn.nineox.xframework.core.common.http.SubscriberCallBack;
import cn.nineox.xframework.core.weiget.top_snackbar.BaseTransientBottomBar;
import cn.nineox.xframework.core.weiget.top_snackbar.TopSnackBar;
import rx.Observable;


public class BasicLogic<DataBinding extends ViewDataBinding> extends BaseLogic<DataBinding> {

    public BasicLogic(DataBinding dataBinding) {
        super(dataBinding);
        setBaseUrl(ApiConstant.BASE_SERVER_URL);
    }

    public BasicLogic(Activity activity, DataBinding dataBinding) {
        super(activity, dataBinding);
        setBaseUrl(ApiConstant.BASE_SERVER_URL);
    }

    public BasicLogic(Fragment fragment, DataBinding dataBinding) {
        super(fragment, dataBinding);
        setBaseUrl(ApiConstant.BASE_SERVER_URL);
    }

    @Override
    public void addSubscription(Observable observable, SubscriberCallBack subscriber) {
        subscriber.setData(mActivity, new SubscriberCallBack.ILogin() {
            @Override
            public void onLoginError() {
                //判断后台返回，执行提示并重新登陆
                AlertDialog alertDialog = new AlertDialog.Builder(mActivity)
                        .setMessage("你的账号在别处登录，请重新登录")
                        .setPositiveButton("好", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (mActivity instanceof LoginSelectActivity) {
                                    BasicActivity.exitApp();
                                    mActivity.startActivity(new Intent(mActivity, LoginSelectActivity.class));
                                }
                            }
                        })
                        .create();
                alertDialog.show();
            }

            @Override
            public void onNetWorkError() {
                TopSnackBar.make(mDataBinding.getRoot(), R.string.networderror, BaseTransientBottomBar.LENGTH_SHORT).show();
            }

            @Override
            public void otherkError(ExceptionHandle.ResponeThrowable responeThrowable) {
                TopSnackBar.make(mDataBinding.getRoot(), responeThrowable.getMessage(), BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
        super.addSubscription(observable, subscriber);
    }
}
