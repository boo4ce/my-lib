package com.vanh.mylib;


import android.content.Intent;

import com.vanh.mylib.databinding.ActivityMainBinding;
import com.vanh.mylib.viewmodel.EmptyViewModel;
import com.vanh.mylibrary.base.BaseActivity;

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
        findViewById(R.id.btn).setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
        });
    }
}
