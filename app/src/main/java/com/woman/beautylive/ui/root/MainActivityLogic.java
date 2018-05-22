package com.woman.beautylive.ui.root;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.woman.beautylive.commom.basic.BasicLogic;
import com.woman.beautylive.databinding.ActivityMainBinding;
import com.woman.beautylive.logic.ApiService;
import com.woman.beautylive.logic.LoginInfoBean;

import cn.nineox.xframework.base.BaseLogic;
import cn.nineox.xframework.core.common.basebeen.APPDataPersistent;
import cn.nineox.xframework.core.common.basebeen.UserBean;
import cn.nineox.xframework.core.common.http.SubscriberCallBack;

public class MainActivityLogic extends BasicLogic<ActivityMainBinding> {


    public MainActivityLogic(Activity activity, ActivityMainBinding binding) {
        super(activity, binding);
    }

    public void login(String code) {
        addSubscription(getRetrofit(ApiService.class).login(code), new SubscriberCallBack<UserBean>() {
            @Override
            protected void onSuccess(UserBean response) {
                APPDataPersistent.getInstance().setUserBean(response, mActivity);
                mActivity.startActivity(new Intent(mActivity, MainActivity.class));
                mActivity.finish();
            }
        });
    }
}
