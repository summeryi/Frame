package cn.nineox.xframework.base.adapter.databinding.recyclerview;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * 使用DataBinding ，告别ViewHolder
 * Created by me on 17/9/27.
 */

public class BaseBindingVH<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected final T mBinding;

    public BaseBindingVH(T t) {
        super(t.getRoot());
        mBinding = t;
    }

    public T getBinding() {
        return mBinding;
    }
}
