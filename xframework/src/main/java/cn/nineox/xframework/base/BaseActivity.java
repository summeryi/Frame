package cn.nineox.xframework.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import me.yokeyword.fragmentation.SupportActivity;


/**
 * Created by aiden on 2/18/16.
 */
public abstract class BaseActivity<DataBinding extends ViewDataBinding, BasicLogic extends BaseLogic> extends SupportActivity implements View.OnClickListener {

    public static long mPreTime;
    protected static Activity mCurrentActivity;// 对所有activity进行管理
    public static List<Activity> mActivities = new LinkedList<Activity>();

    protected DataBinding mViewDataBinding;
    protected BasicLogic mLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScream();
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mLogic = initLogic();
        createViewBinding();

        //初始化的时候将其添加到集合中,synchronized当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。
        synchronized (mActivities) {
            mActivities.add(this);
        }

    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract BasicLogic initLogic();

    @NonNull
    protected abstract void createViewBinding();


    protected void FullScream() {

    }

    @Override
    public void onClick(View v) {

    }


    //判断是否大于1
    public boolean isInStack() {

        if (mActivities.size() > 1) {
            return true;
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCurrentActivity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCurrentActivity = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mLogic != null) {
            if (mLogic.mCompositeSubscription != null) {
                mLogic.mCompositeSubscription.unsubscribe();
            }
        }
        //销毁的时候从集合中移除
        synchronized (mActivities) {
            mActivities.remove(this);
        }
    }

    /**
     * 退出应用的方法
     */
    public static void exitApp() {
        ListIterator<Activity> iterator = mActivities.listIterator();
        while (iterator.hasNext()) {
            Activity next = iterator.next();
            next.finish();
        }
    }

    public static Activity getCurrentActivity() {
        return mCurrentActivity;
    }
}
