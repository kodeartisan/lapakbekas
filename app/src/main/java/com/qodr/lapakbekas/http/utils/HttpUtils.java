package com.qodr.lapakbekas.http.utils;

import com.qodr.lapakbekas.AppConstants;
import com.qodr.lapakbekas.http.LifeSubscription;
import com.qodr.lapakbekas.http.Stateful;
import com.qodr.lapakbekas.utils.NetworkUtils;
import com.qodr.lapakbekas.utils.ToastUtils;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kodeartisan on 14/05/17.
 */
public class HttpUtils {

    public static <T> void invoke(LifeSubscription lifeSubscription, Observable<T> observable, Callback<T> callback) {
        Stateful target = null;
        if(lifeSubscription instanceof Stateful) {
            target = (Stateful) lifeSubscription;
            callback.setTarget(target);
        }

        if(!NetworkUtils.isConnected()) {
            ToastUtils.showShort("No internet connection");

            if(target != null) {
                target.setState(AppConstants.STATE_ERROR);
            }
            return;
        }

        Subscription subscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
        lifeSubscription.bindSubscription(subscription);
    }
}
