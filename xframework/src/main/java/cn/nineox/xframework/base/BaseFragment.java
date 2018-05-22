package cn.nineox.xframework.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by me on 17/9/26.
 */

public abstract class BaseFragment<DataBinding extends ViewDataBinding, BasicLogic extends BaseLogic> extends SupportFragment implements View.OnClickListener {

    protected DataBinding mViewDataBinding;
    protected BasicLogic mLogic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mLogic = initLogic();
        return mViewDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createViewBinding();
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract BasicLogic initLogic();

    protected abstract void createViewBinding();

    @Override
    public void onClick(View view) {

    }
}
