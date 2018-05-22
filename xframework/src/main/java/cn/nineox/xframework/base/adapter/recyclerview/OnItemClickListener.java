package cn.nineox.xframework.base.adapter.recyclerview;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by me on 17/9/27.
 */
public interface OnItemClickListener<T>
{
    void onItemClick(ViewGroup parent, View view, T t, int position);
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}