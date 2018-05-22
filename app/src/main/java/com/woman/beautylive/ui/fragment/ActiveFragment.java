package com.woman.beautylive.ui.fragment;

import com.woman.beautylive.R;
import com.woman.beautylive.databinding.FragmentActiveBinding;

import cn.nineox.xframework.base.BaseLogic;
import cn.nineox.xframework.base.LazyFragment;

public class ActiveFragment extends LazyFragment<FragmentActiveBinding,BaseLogic> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_active;
    }

    @Override
    protected BaseLogic initLogic() {
        return null;
    }

    @Override
    protected void createViewBinding() {

    }
}
