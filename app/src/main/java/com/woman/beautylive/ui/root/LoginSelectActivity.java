package com.woman.beautylive.ui.root;

import android.support.annotation.NonNull;

import com.woman.beautylive.R;
import com.woman.beautylive.commom.basic.BasicActivity;
import com.woman.beautylive.databinding.ActivityLoginselectBinding;

import cn.nineox.xframework.base.BaseLogic;

public class LoginSelectActivity extends BasicActivity<ActivityLoginselectBinding, BaseLogic> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_loginselect;
    }

    @Override
    protected BaseLogic initLogic() {
        return null;
    }

    @NonNull
    @Override
    protected void createViewBinding() {

    }
}
