package com.vanh.mylib.rv;

import com.vanh.mylibrary.base.adapter.BaseItem;
import com.vanh.mylibrary.base.adapter.ItemData;

public class Item extends BaseItem<String> {
    private String title;

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    protected String getMainData() {
        return title;
    }

    @Override
    public String getCompareContent() {
        return title;
    }
}
