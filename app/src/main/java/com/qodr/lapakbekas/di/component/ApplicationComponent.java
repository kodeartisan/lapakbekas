package com.qodr.lapakbekas.di.component;

import android.content.Context;

import com.qodr.lapakbekas.BaseApplication;
import com.qodr.lapakbekas.di.module.AppModule;
import com.qodr.lapakbekas.di.module.http.BukalapakHttpModule;
import com.qodr.lapakbekas.di.scope.ContextLife;
import com.qodr.lapakbekas.rx.RxBus;
import com.qodr.lapakbekas.utils.PreferencesUtils;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kodeartisan on 14/05/17.
 */
@Singleton
@Component(modules = {AppModule.class, BukalapakHttpModule.class})
public interface ApplicationComponent {

    @ContextLife()
    Context getContext();

    PreferencesUtils getPreferencesUtils();

    RxBus getRxBus();


}
