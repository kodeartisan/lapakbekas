package com.qodr.lapakbekas.listener;

/**
 * Created by kodeartisan on 15/05/17.
 */
public interface RequestCallBack<T> {

    void beforeRequest();

    void success(T data);

    void onError(String errorMsg);
}
