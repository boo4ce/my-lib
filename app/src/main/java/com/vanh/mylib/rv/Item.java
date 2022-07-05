package com.vanh.mylib.rv;

import com.vanh.mylibrary.base.adapter.ItemData;

public class Item implements ItemData<ViewHolder2> {
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
    public String getCompareContent() {
        return title;
    }

    @Override
    public void bind(ViewHolder2 viewHolder) {
        viewHolder.setTitle(title);
    }
}
