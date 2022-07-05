package com.vanh.mylib.rv;

import com.vanh.mylibrary.base.adapter.DynamicAdapter;
import com.vanh.mylibrary.base.adapter.ItemData;
import com.vanh.mylibrary.base.adapter.ItemTemplate;

import java.util.List;

public class Adapter extends DynamicAdapter<ViewHolder2> {
    public Adapter(ItemTemplate<ViewHolder2> template, List<ItemData<ViewHolder2>> dataList) {
        super(template, dataList);
    }
}
