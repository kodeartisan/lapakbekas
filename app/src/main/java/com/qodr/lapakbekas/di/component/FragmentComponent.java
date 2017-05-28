package com.qodr.lapakbekas.di.component;

import android.content.Context;

import com.qodr.lapakbekas.di.module.http.BukalapakHttpModule;
import com.qodr.lapakbekas.di.scope.ContextLife;
import com.qodr.lapakbekas.di.scope.FragmentScope;
import com.qodr.lapakbekas.http.utils.RetrofitBukalapakUtils;
import com.qodr.lapakbekas.mvp.ui.fragment.HomeFragment;
import com.qodr.lapakbekas.mvp.ui.fragment.MainFragment;
import com.qodr.lapakbekas.rx.RxBus;
import com.qodr.lapakbekas.utils.PreferencesUtils;

import dagger.Component;

/**
 * Created by kodeartisan on 25/05/17.
 */

@FragmentScope
@Component(dependencies = {ActivityComponent.class})
public interface FragmentComponent {


    void inject(MainFragment fragment);
    void inject(HomeFragment fragment);
}
