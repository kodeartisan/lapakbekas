package com.qodr.lapakbekas.mvp.presenter.impl;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.qodr.lapakbekas.BaseApplication;
import com.qodr.lapakbekas.base.BaseView;
import com.qodr.lapakbekas.di.scope.ContextLife;
import com.qodr.lapakbekas.entity.ProductWrapper;
import com.qodr.lapakbekas.event.EventConstant;
import com.qodr.lapakbekas.event.ProductEvent;
import com.qodr.lapakbekas.http.utils.RetrofitBukalapakUtils;
import com.qodr.lapakbekas.mvp.presenter.IHomeFragmentPresenter;
import com.qodr.lapakbekas.mvp.view.IHomeFragmentView;
import com.qodr.lapakbekas.mvp.view.IHomeView;
import com.qodr.lapakbekas.rx.RxBus;

import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kodeartisan on 25/05/17.
 */

public class HomeFragmentPresenterImpl implements IHomeFragmentPresenter {
    public static final String TAG = HomeFragmentPresenterImpl.class.getSimpleName();

    private IHomeFragmentView mHomeFragmentView;
    private final RxBus mRxBus;
    private final RetrofitBukalapakUtils mRetrofitBukalapakUtils;


    @Inject
    public HomeFragmentPresenterImpl(RxBus rxBus, RetrofitBukalapakUtils retrofitBukalapakUtils) {

        this.mRxBus = rxBus;
        this.mRetrofitBukalapakUtils = retrofitBukalapakUtils;


    }

    @Override
    public void attachView(@NonNull BaseView view) {
        mHomeFragmentView = (IHomeFragmentView) view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void fetchProducts(Map<String, String> options) {

        mHomeFragmentView.showProgress();
        //mHomeFragmentView.showProgress("Loading...");
         mRetrofitBukalapakUtils.fetchProducts(options)
                 .enqueue(new Callback<ProductWrapper>() {
                     @Override
                     public void onResponse(Call<ProductWrapper> call, Response<ProductWrapper> response) {
                         Log.d(TAG, response.body().getProducts().get(0).getName() + "");

                         mRxBus.post(new ProductEvent(null, response.body().getProducts(), EventConstant.ADD));
                     }

                     @Override
                     public void onFailure(Call<ProductWrapper> call, Throwable t) {
                         Log.d(TAG, t.getMessage());
                         //Toast.makeText(mContext, "Error", Toast.LENGTH_SHORT).show();
                     }
                 });
    }
}
