package com.vanh.mylib.rv;

import android.view.View;

import androidx.annotation.NonNull;

import com.vanh.mylib.databinding.ItemviewBinding;
import com.vanh.mylibrary.base.adapter.DynamicAdapter;
import com.vanh.mylibrary.base.adapter.callback.OnItemClick;

public class ViewHolder2 extends DynamicAdapter.ViewHolder<ItemviewBinding> {
    public ViewHolder2(@NonNull ItemviewBinding binding, OnItemClick<DynamicAdapter.ViewHolder<ItemviewBinding>> listener) {
        super(binding, listener);
    }

    public void setTitle(String title) {
        binding.tv.setText(title);
    }
}
