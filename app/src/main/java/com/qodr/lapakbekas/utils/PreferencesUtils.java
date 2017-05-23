package com.qodr.lapakbekas.utils;

/**
 * Created by kodeartisan on 14/05/17.
 */
import android.content.Context;
import android.content.SharedPreferences;

import com.qodr.lapakbekas.di.scope.ContextLife;

import javax.inject.Inject;


public final class PreferencesUtils {

    private static final String SETTING = "quidesetting";

    public static final String RATE_IT = "rate_it";

    private static SharedPreferences mSharedPreferences;

    @Inject
    public PreferencesUtils(@ContextLife() Context context) {
        mSharedPreferences = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE);
    }

    public boolean contains(String key) {
        return mSharedPreferences.contains(key);
    }

    public boolean getBoolean(final String key, final boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    public int getInt(final String key, final int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public String getString(final String key, final String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public boolean putInt(final String key, final int value) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putInt(key, value);

        return editor.commit();

    }

    public boolean putBoolean(final String key, final Boolean value) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putBoolean(key, value);

        return editor.commit();

    }

    public boolean putString(final String key, final String value) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putString(key, value);

        return editor.commit();

    }
}
