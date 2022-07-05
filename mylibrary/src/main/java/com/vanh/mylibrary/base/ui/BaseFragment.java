package com.vanh.mylibrary.base.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<T extends ViewBinding, V extends BaseViewModel>
        extends Fragment {
    protected T binding;
    protected V mViewModel;

    protected BaseActivity mActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModelProvider();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = getViewBinding(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    protected Context getContextFuckingSafety() {
        if(isAdded() && !requireActivity().isFinishing()) return requireContext();
        return null;
    }

    protected Activity getActivityFuckingSafety() {
        if(isAdded() && !requireActivity().isFinishing()) return mActivity;
        return null;
    }

    protected abstract T getViewBinding(LayoutInflater inflater, ViewGroup parent, boolean attachTo);
    protected abstract V getViewModelProvider();

    public static final String TAG = "vanh";
}
