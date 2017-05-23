package com.qodr.lapakbekas.http.utils;

import com.qodr.lapakbekas.http.Stateful;

import rx.Subscriber;

/**
 * Created by kodeartisan on 14/05/17.
 */
public class Callback<T> extends Subscriber<T> {

    private Stateful target;

    public void setTarget(Stateful target) {
        this.target = target;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();

    }

    @Override
    public void onNext(T t) {

    }

    public void onFail() {
        //if
    }
}
