package com.woman.beautylive.ui.fragment;
import com.woman.beautylive.R;
import com.woman.beautylive.databinding.FragmentMainBinding;
import cn.nineox.xframework.base.BaseFragment;
import cn.nineox.xframework.base.BaseLogic;
import cn.nineox.xframework.core.weiget.BottomBar;
import cn.nineox.xframework.core.weiget.BottomBarTab;
import me.yokeyword.fragmentation.SupportFragment;

public class MainFragment extends BaseFragment<FragmentMainBinding,BaseLogic> {

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int Fourth = 3;

    private SupportFragment[] mFragments = new SupportFragment[4];

    public static final String TAG = "MainFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected BaseLogic initLogic() {
        return null;
    }

    @Override
    protected void createViewBinding() {
        mViewDataBinding.setClickListener(this);
        refresh();
    }

    private void refresh() {
        SupportFragment firstFragment = findChildFragment(ServiceFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = new ServiceFragment();
            mFragments[SECOND] = new ConsultFragment();
            mFragments[THIRD] = new ActiveFragment();
            mFragments[Fourth] = new MineFragment();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[Fourth]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.findFragmentByTag自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findChildFragment(ConsultFragment.class);
            mFragments[THIRD] = findChildFragment(ActiveFragment.class);
            mFragments[Fourth] = findChildFragment(MineFragment.class);
        }


        mViewDataBinding.bottomBar
                .addItem(new BottomBarTab(_mActivity, R.drawable.tab_service, getString(R.string.service)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.tab_consult, getString(R.string.consult)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.tab_active, getString(R.string.active)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.tab_mine, getString(R.string.mine)));

        mViewDataBinding.bottomBar.invalidate();
        mViewDataBinding.bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                // 在FirstPagerFragment,FirstHomeFragment中接收, 因为是嵌套的Fragment
                // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
                //EventBus.getDefault().post(new TabSelectedEvent(position));
            }

            @Override
            public void onRoundTabSelected() {

            }
        });

    }
}

