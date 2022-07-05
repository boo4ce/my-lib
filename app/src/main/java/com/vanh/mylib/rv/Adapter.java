package com.vanh.mylib.rv;

import com.vanh.mylibrary.base.adapter.BaseAdapter;
import com.vanh.mylibrary.base.adapter.ItemData;
import com.vanh.mylibrary.base.adapter.ItemTemplate;

import java.util.List;

public class Adapter extends BaseAdapter {
    public Adapter(ItemTemplate template, List<ItemData> dataList) {
        super(template, dataList);
    }
}
