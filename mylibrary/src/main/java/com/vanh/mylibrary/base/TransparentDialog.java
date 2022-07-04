package com.vanh.mylibrary.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import androidx.annotation.NonNull;

public abstract class TransparentDialog extends Dialog {
    public TransparentDialog(@NonNull Context context) {
        super(context);
        requestTransparent();

        initView();
    }

    private void requestTransparent() {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    }

    protected abstract void initView();
}
