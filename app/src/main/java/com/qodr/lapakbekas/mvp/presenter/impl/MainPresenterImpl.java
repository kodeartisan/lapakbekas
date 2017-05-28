package com.qodr.lapakbekas.mvp.presenter.impl;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.qodr.lapakbekas.R;
import com.qodr.lapakbekas.base.BaseView;
import com.qodr.lapakbekas.di.scope.ContextLife;
import com.qodr.lapakbekas.event.SearchProductEvent;
import com.qodr.lapakbekas.http.utils.RetrofitBukalapakUtils;
import com.qodr.lapakbekas.mvp.presenter.IMainPresenter;
import com.qodr.lapakbekas.mvp.view.IHomeView;
import com.qodr.lapakbekas.rx.RxBus;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by kodeartisan on 15/05/17.
 */
public class MainPresenterImpl extends BasePresenterImpl implements IMainPresenter {

    private IHomeView mHomeView;
    private final Context mContext;
    private final Activity mActivity;
    private final RxBus mRxBus;
    private final RetrofitBukalapakUtils mRetrofitBukalapakUtils;
    private String mCurrentFragmentTag;

    @Inject
    public MainPresenterImpl(@ContextLife() Context context, Activity activity, RxBus rxBus, RetrofitBukalapakUtils retrofitBukalapakUtils) {
        this.mContext = context;
        this.mActivity = activity;
        this.mRxBus = rxBus;
        this.mRetrofitBukalapakUtils = retrofitBukalapakUtils;
    }

    @Override
    public void attachView(@NonNull BaseView view) {
        mHomeView = (IHomeView) view;
    }

    @Override
    public void detachView() {
        unsubscribe();
    }

    @Override
    public void replaceFragment(Fragment to, String tag, boolean isExpanded) {
       FragmentManager fragmentManager =  ((AppCompatActivity) mActivity).getSupportFragmentManager();
       Fragment currentFragment = fragmentManager.findFragmentByTag(mCurrentFragmentTag);

       if(currentFragment == null || !TextUtils.equals(tag, mCurrentFragmentTag)) {
           mCurrentFragmentTag = tag;
           fragmentManager.beginTransaction().replace(R.id.fragment_container, to, mCurrentFragmentTag).commit();
       }
    }

    @Override
    public void searchProduct(HashMap<String, String> data) {
        mRxBus.post(new SearchProductEvent(data));
    }


}
