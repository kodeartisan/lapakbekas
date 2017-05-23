package com.qodr.lapakbekas;

import android.app.Application;
import android.content.Context;

import com.qodr.lapakbekas.di.component.ApplicationComponent;
import com.qodr.lapakbekas.di.component.DaggerApplicationComponent;
import com.qodr.lapakbekas.di.module.AppModule;
import com.qodr.lapakbekas.di.module.http.BukalapakHttpModule;

/**
 * Created by kodeartisan on 14/05/17.
 */
public class BaseApplication extends Application {

    private static Context mContext;
    private static BaseApplication mBaseApplication;
    public static ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mBaseApplication = this;
        initComponent();
        //mApplicationComponent.inject(this);
    }

    public static Context getContext() {
        return mContext;
    }

    public void initComponent() {
        if(mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .appModule(new AppModule(mBaseApplication))
                    .bukalapakHttpModule(new BukalapakHttpModule())
                    .build();
        }
    }

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
