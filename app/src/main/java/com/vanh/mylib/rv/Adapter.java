package com.vanh.mylib.rv;

import com.vanh.mylibrary.base.adapter.DynamicAdapter;
import com.vanh.mylibrary.base.adapter.ItemData;
import com.vanh.mylibrary.base.adapter.ItemTemplate;

import java.util.List;

public class Adapter extends DynamicAdapter<ViewHolder> {
    public Adapter(ItemTemplate<ViewHolder> template, List<ItemData<ViewHolder>> dataList) {
        super(template, dataList);
    }
}
