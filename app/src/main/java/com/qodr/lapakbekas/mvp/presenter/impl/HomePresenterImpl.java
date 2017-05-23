package com.qodr.lapakbekas.mvp.presenter.impl;

import android.support.annotation.NonNull;

import com.qodr.lapakbekas.base.BaseView;
import com.qodr.lapakbekas.mvp.presenter.HomePresenter;

/**
 * Created by kodeartisan on 15/05/17.
 */
public class HomePresenterImpl extends BasePresenterImpl implements HomePresenter {

    @Override
    public void attachView(@NonNull BaseView view) {

    }

    @Override
    public void detachView() {
        unsubscribe();
    }
}
