package com.vanh.mylibrary.base.adapter.callback;

import androidx.viewbinding.ViewBinding;

import com.vanh.mylibrary.base.adapter.BaseAdapter;

public interface OnItemClick<T extends BaseAdapter.BaseViewHolder<? extends ViewBinding>> {
    void onItemClicked(T viewHolder);
}
