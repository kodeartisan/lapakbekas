package com.qodr.lapakbekas.di.module;

import android.content.Context;

import com.qodr.lapakbekas.BaseApplication;
import com.qodr.lapakbekas.di.scope.ContextLife;
import com.qodr.lapakbekas.rx.RxBus;
import com.qodr.lapakbekas.utils.PreferencesUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kodeartisan on 14/05/17.
 */
@Module
public class AppModule {

    private final BaseApplication baseApplication;
    private final RxBus mRxBus;
    private final PreferencesUtils mPreferencesUtils;

    public AppModule(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
        this.mRxBus = new RxBus();
        this.mPreferencesUtils = new PreferencesUtils(baseApplication.getApplicationContext());
    }

    @Provides
    @Singleton
    @ContextLife
    Context provideApplicationContext() {
        return baseApplication;
    }

    @Provides
    @Singleton
    RxBus provideRxBus() {
        return mRxBus;
    }

    @Provides
    @Singleton
    PreferencesUtils providePreferencesUtils() {
        return mPreferencesUtils;
    }

}
