package com.vanh.mylib.rv;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.vanh.mylib.R;
import com.vanh.mylib.databinding.ItemviewBinding;
import com.vanh.mylibrary.base.adapter.BaseAdapter;
import com.vanh.mylibrary.base.adapter.callback.OnItemClick;

public class ViewHolder extends BaseAdapter.BaseViewHolder<ItemviewBinding> {
    public ViewHolder(@NonNull ItemviewBinding binding, OnItemClick listener) {
        super(binding, listener);
    }

    public void setTitle(String title) {
        binding.tv.setText(title);
    }
}
