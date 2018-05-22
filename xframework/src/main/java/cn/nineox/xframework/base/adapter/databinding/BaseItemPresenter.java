package cn.nineox.xframework.base.adapter.databinding;

/**
 *
 * RecyclerView 点击事件接口类
 * Created by me on 17/10/29.
 */

public interface BaseItemPresenter<T> {

    public void onItemClick(T t, int position);

    public boolean onItemLongClick(T t, int position);
}
