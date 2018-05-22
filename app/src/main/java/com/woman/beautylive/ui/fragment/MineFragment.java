package com.woman.beautylive.ui.fragment;

import com.woman.beautylive.R;
import com.woman.beautylive.databinding.FragmentMineBinding;

import cn.nineox.xframework.base.BaseLogic;
import cn.nineox.xframework.base.LazyFragment;

public class MineFragment extends LazyFragment<FragmentMineBinding,BaseLogic> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected BaseLogic initLogic() {
        return null;
    }

    @Override
    protected void createViewBinding() {

    }
}
