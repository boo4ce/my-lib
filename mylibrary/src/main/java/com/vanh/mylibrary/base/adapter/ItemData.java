package com.vanh.mylibrary.base.adapter;

import androidx.viewbinding.ViewBinding;

public interface ItemData<T extends DynamicAdapter.BaseViewHolder<? extends ViewBinding>> {
    /**
     * This method use for compare areItemsTheSame(DiffCallback)
     * @return
     */
    String getCompareContent();
    void bind(T viewHolder);
}
