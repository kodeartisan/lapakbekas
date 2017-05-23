package com.qodr.lapakbekas.di.module;

import android.app.Activity;
import android.content.Context;

import com.qodr.lapakbekas.di.scope.ActivityScope;
import com.qodr.lapakbekas.di.scope.ContextLife;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kodeartisan on 14/05/17.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    @ContextLife("Activity")
    public Context provideContext() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }

}
