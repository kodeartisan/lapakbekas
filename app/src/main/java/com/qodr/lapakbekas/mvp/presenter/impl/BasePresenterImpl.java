package com.qodr.lapakbekas.mvp.presenter.impl;

import com.qodr.lapakbekas.base.BasePresenter;

import rx.Subscription;

/**
 * Created by kodeartisan on 15/05/17.
 */
public abstract class BasePresenterImpl implements BasePresenter {

    protected Subscription mSubscription;

    protected void unsubscribe() {
        if(mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
