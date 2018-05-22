package cn.nineox.xframework.base.adapter.databinding.recyclerview.inf;

/**
 * 介绍：多种类型viewType的ViewModel需要实现的接口
 * 根据不同的itemType返回不同的ItemLayoutId
 * Created by me on 17/9/27.
 */

public interface IBaseTypeInterface {
    public int getItemLayoutId();
}
