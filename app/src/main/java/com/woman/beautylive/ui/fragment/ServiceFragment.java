package com.woman.beautylive.ui.fragment;

import com.woman.beautylive.R;
import com.woman.beautylive.databinding.FragmentServiceBinding;

import cn.nineox.xframework.base.BaseLogic;
import cn.nineox.xframework.base.LazyFragment;
import me.yokeyword.fragmentation.SupportFragment;

public class ServiceFragment extends LazyFragment<FragmentServiceBinding, BaseLogic> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_service;
    }

    @Override
    protected BaseLogic initLogic() {
        return null;
    }

    @Override
    protected void createViewBinding() {

    }
}
