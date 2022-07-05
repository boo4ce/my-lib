package com.vanh.mylibrary.base.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public interface ItemTemplate<T extends BaseAdapter.BaseViewHolder<? extends ViewBinding>, G extends ItemData> {
    void bind(T viewHolder, G data);
    T inflate(LayoutInflater layoutInflater, ViewGroup parent, boolean attachTo);
}
