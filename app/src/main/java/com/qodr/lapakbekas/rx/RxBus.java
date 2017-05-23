package com.qodr.lapakbekas.rx;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/**
 * Created by kodeartisan on 14/05/17.
 */
public class RxBus {
    private final SerializedSubject mSubject;

    public RxBus() {
        mSubject = new SerializedSubject<>(PublishSubject.create());
    }

    public void post(Object o) {
        mSubject.onNext(o);
    }

    public <T>Observable<T> toObservable(Class<T> eventType) {
        return mSubject.ofType(eventType);
    }
}
