package com.vanh.mylibrary.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBinding;

import com.vanh.mylibrary.utils.languages.LanguageUtils;
import com.vanh.mylibrary.utils.time.TimeUtils;

import java.util.Locale;

public abstract class BaseActivity<T extends ViewBinding, V extends BaseViewModel>
        extends AppCompatActivity {
    protected T binding;
    protected V mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewBinding();
        mViewModel = getViewModel();
        setContentView(binding.getRoot());

        getLanguage();

        initView();
    }

    private void getLanguage() {
        Locale locale = new Locale(LanguageUtils.getCurrentLanguage(this));

        setLanguage(locale);
    }

    protected void changeLanguage(String languageCode) {
        LanguageUtils.saveCurrentLanguage(this, languageCode);

        restartApp(this.getClass());
    }

    private void restartApp(Class cls) {
        startActivity(new Intent(this, cls)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .putExtra("is_restart", true)
        );
    }

    private void setLanguage(Locale locale) {
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

        TimeUtils.getInstance().changeFormat();
    }

    protected void changeStatusBarColor(int colorResourceId) {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, colorResourceId));
    }

    protected abstract T getViewBinding();
    protected abstract V getViewModel();

    /**
     * this method would be called in onCreate
     */
    protected abstract void initView();
}
