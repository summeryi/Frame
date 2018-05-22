package com.woman.beautylive.commom.basic;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.widget.Toast;

import com.woman.beautylive.R;
import com.woman.beautylive.ui.root.MainActivity;

import cn.nineox.xframework.base.BaseActivity;
import cn.nineox.xframework.base.BaseLogic;
import cn.nineox.xframework.core.common.flyn.Eyes;

public abstract class BasicActivity<DataBinding extends ViewDataBinding, BasicLogic extends BaseLogic> extends BaseActivity<DataBinding, BasicLogic> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化的时候将其添加到集合中,synchronized当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。
        synchronized (mActivities) {
            mActivities.add(this);
        }

        Eyes.setStatusBarColor(this, getResources().getColor(R.color.colorPrimaryDark));
//        if (!QMUIStatusBarHelper.setStatusBarLightMode(this)) {
//            Eyes.setStatusBarColor(this, getResources().getColor(R.color.black_text_color));
//        }

    }


    /**
     * 统一退出控制
     */
    @Override
    public void onBackPressedSupport() {
        if (mCurrentActivity instanceof MainActivity) {
            //如果是主页面
            if (System.currentTimeMillis() - mPreTime > 2000) {// 两次点击间隔大于2秒
                Toast.makeText(mCurrentActivity, "再按一次，退出应用", Toast.LENGTH_SHORT).show();
                mPreTime = System.currentTimeMillis();
                return;
            }
        }
        super.onBackPressedSupport();// finish()
    }

}


