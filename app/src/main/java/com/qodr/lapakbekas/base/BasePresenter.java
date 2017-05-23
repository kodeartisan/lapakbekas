package com.qodr.lapakbekas.base;

import android.support.annotation.NonNull;

import com.qodr.lapakbekas.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by kodeartisan on 15/05/17.
 */
public interface BasePresenter {
    void attachView(@NonNull BaseView view);


    void detachView();
}