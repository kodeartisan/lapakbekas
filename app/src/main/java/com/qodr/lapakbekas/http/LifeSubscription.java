package com.qodr.lapakbekas.http;

import rx.Subscription;

/**
 * Created by kodeartisan on 14/05/17.
 */
public interface LifeSubscription {

    void bindSubscription(Subscription subscription);

}
