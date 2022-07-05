package com.vanh.mylibrary.base.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public interface ItemTemplate<T extends RecyclerView.ViewHolder> {
    T inflate(LayoutInflater layoutInflater, ViewGroup parent, boolean attachTo);
}
