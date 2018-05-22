package cn.nineox.xframework.base;

        import android.databinding.ViewDataBinding;
        import android.os.Bundle;
        import android.support.annotation.Nullable;

public abstract class LazyFragment<DataBinding extends ViewDataBinding, BasicLogic extends BaseLogic> extends BaseFragment<DataBinding, BasicLogic> {
    /**
     * 懒加载
     */
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {

    }
}

