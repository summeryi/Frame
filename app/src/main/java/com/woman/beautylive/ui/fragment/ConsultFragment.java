package com.woman.beautylive.ui.fragment;

import com.woman.beautylive.R;
import com.woman.beautylive.databinding.FragmentConsultBinding;

import cn.nineox.xframework.base.BaseLogic;
import cn.nineox.xframework.base.LazyFragment;

public class ConsultFragment extends LazyFragment<FragmentConsultBinding,BaseLogic> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_consult;
    }

    @Override
    protected BaseLogic initLogic() {
        return null;
    }

    @Override
    protected void createViewBinding() {

    }
}
