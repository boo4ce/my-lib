package com.vanh.mylibrary.base.adapter.callback;

import androidx.viewbinding.ViewBinding;

import com.vanh.mylibrary.base.adapter.DynamicAdapter;

public interface OnItemClick<T extends DynamicAdapter.BaseViewHolder<? extends ViewBinding>> {
    void onItemClicked(T viewHolder);
}
