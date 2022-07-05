package com.vanh.mylib;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.vanh.mylib.databinding.ActivityMainBinding;
import com.vanh.mylib.databinding.ItemviewBinding;
import com.vanh.mylib.rv.Adapter;
import com.vanh.mylib.rv.Item;
import com.vanh.mylib.rv.ViewHolder;
import com.vanh.mylib.viewmodel.EmptyViewModel;
import com.vanh.mylibrary.base.adapter.ItemData;
import com.vanh.mylibrary.base.adapter.ItemTemplate;
import com.vanh.mylibrary.base.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding, EmptyViewModel> {
    @Override
    protected ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected EmptyViewModel getViewModel() {
        return new EmptyViewModel();
    }

    @Override
    protected void initView() {
        RecyclerView rv = findViewById(R.id.rv);

        List<ItemData<ViewHolder>> list = new ArrayList<>();
        list.add(new Item("Hello"));
        list.add(new Item("Hello 1"));
        list.add(new Item("Hello 2"));
        list.add(new Item("Hello 3"));

        rv.setAdapter(new Adapter(new ItemTemplate<ViewHolder>() {
            @Override
            public ViewHolder inflate(LayoutInflater layoutInflater, ViewGroup parent, boolean attachTo) {
                return new ViewHolder(ItemviewBinding.inflate(layoutInflater, parent, attachTo), viewHolder -> {
                    Toast.makeText(MainActivity.this, viewHolder.getData().getCompareContent(), Toast.LENGTH_SHORT).show();
                });
            }
        }, list));
    }
}
