package com.vanh.mylib;

import com.vanh.mylib.databinding.ActivityMainBinding;
import com.vanh.mylib.viewmodel.EmptyViewModel;
import com.vanh.mylibrary.base.ui.BaseActivity;

public class SecondActivity extends BaseActivity<ActivityMainBinding, EmptyViewModel> {
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
//        findViewById(R.id.btn).setOnClickListener(view -> {
//            changeLanguage("en");
//        });
    }
}
