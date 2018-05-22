package cn.nineox.xframework.base.adapter.recyclerview.inf;

import cn.nineox.xframework.base.adapter.recyclerview.ViewHolder;

/**
 * 介绍：受DataBinding启发，将数据填充方法挪出来
 * Created by me on 17/9/27.
 */

public interface IMulTypeHelper {

    int getItemLayoutId();

    void onBind(ViewHolder holder);
}
