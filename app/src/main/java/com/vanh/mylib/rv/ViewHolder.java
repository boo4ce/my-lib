package com.vanh.mylib.rv;

import androidx.annotation.NonNull;

import com.vanh.mylib.databinding.ItemviewBinding;
import com.vanh.mylibrary.base.adapter.DynamicAdapter;
import com.vanh.mylibrary.base.adapter.callback.OnItemClick;

public class ViewHolder extends DynamicAdapter.BaseViewHolder<ItemviewBinding> {
    public ViewHolder(@NonNull ItemviewBinding binding, OnItemClick listener) {
        super(binding, listener);
    }

    public void setTitle(String title) {
        binding.tv.setText(title);
    }
}
