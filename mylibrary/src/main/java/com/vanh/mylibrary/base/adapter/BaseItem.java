package com.vanh.mylibrary.base.adapter;

public abstract class BaseItem<T> implements ItemData {
    protected abstract T getMainData();
}
