package com.qodr.lapakbekas.di.component;

import android.content.Context;

import com.qodr.lapakbekas.di.module.ActivityModule;
import com.qodr.lapakbekas.di.scope.ActivityScope;
import com.qodr.lapakbekas.di.scope.ContextLife;
import com.qodr.lapakbekas.mvp.ui.activity.HomeActivity;
import com.qodr.lapakbekas.rx.RxBus;
import com.qodr.lapakbekas.utils.PreferencesUtils;

import dagger.Component;

/**
 * Created by kodeartisan on 15/05/17.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife
    Context getApplicationContext();

    PreferencesUtils getPreferencesUtils();

    RxBus getRxBus();

    void inject(HomeActivity activity);
}
