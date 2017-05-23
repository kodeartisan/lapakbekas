package com.qodr.lapakbekas.base;

/**
 * Created by kodeartisan on 15/05/17.
 */
public interface BaseView {

    void showProgress(String message);

    void showProgress(String message, int progress);

    void hideProgress();

    void showToast(String msg);

    void close();

}
