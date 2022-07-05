package com.vanh.mylibrary.base.adapter.callback;

import android.view.View;

import androidx.viewbinding.ViewBinding;

import com.vanh.mylibrary.base.adapter.DynamicAdapter;

public interface OnItemClick<T extends DynamicAdapter.ViewHolder<? extends ViewBinding>> {
    void onItemClicked(View view, T viewHolder);
}
