package com.qodr.lapakbekas.mvp.ui.activity;


import com.qodr.lapakbekas.R;
import com.qodr.lapakbekas.base.BaseActivity;
import com.qodr.lapakbekas.mvp.view.HomeView;
import com.qodr.lapakbekas.rx.RxBus;

import javax.inject.Inject;


public class HomeActivity extends BaseActivity implements HomeView{

    public static final String TAG = HomeActivity.class.getSimpleName();

    @Inject
    RxBus mRxBus;



    @Override
    protected void initData() {

    }

    @Override
    public void initDagger() {
        mActivityComponent.inject(this);
    }

    @Override
    public void initViewsAndListener() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initToolbar() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }



}
