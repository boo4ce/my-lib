package com.vanh.mylibrary.utils.languages;

import android.content.Context;
import android.content.SharedPreferences;

import com.vanh.mylibrary.utils.time.TimeUtils;

public class LanguageUtils {
    public final static String LANGUAGE_SCHEME = "current_language";
    public final static String LANGUAGE_NAME_SHARE = "lang_code";

//    private static LanguageUtils instance = null;
//    private String currentLanguage = "en";

    private LanguageUtils() {}

//    public static LanguageUtils getInstance() {
//        if(instance == null) {
//            synchronized (TimeUtils.class) {
//                if (instance == null)
//                    instance = new LanguageUtils();
//            }
//        }
//
//        return instance;
//    }
//
//    public String getCurrentLanguage() {
//        return currentLanguage;
//    }
//
//    public void setCurrentLanguage(String currentLanguage) {
//        this.currentLanguage = currentLanguage;
//    }

    public static void saveCurrentLanguage(Context context, String langCode) {
        SharedPreferences sharedPreferences = getShared(context);

        sharedPreferences.edit()
            .putString(LANGUAGE_NAME_SHARE, langCode)
            .apply();
    }

    public static String getCurrentLanguage(Context context) {
        SharedPreferences sharedPreferences = getShared(context);

        return sharedPreferences.getString(LANGUAGE_NAME_SHARE, "en");
    }

    private static SharedPreferences getShared(Context context) {
        return context.getSharedPreferences(LANGUAGE_SCHEME, Context.MODE_PRIVATE);
    }
}
