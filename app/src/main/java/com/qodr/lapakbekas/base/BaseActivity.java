package com.qodr.lapakbekas.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.qodr.lapakbekas.BaseApplication;
import com.qodr.lapakbekas.R;
import com.qodr.lapakbekas.di.component.ActivityComponent;
import com.qodr.lapakbekas.di.component.DaggerActivityComponent;
import com.qodr.lapakbekas.di.module.ActivityModule;
import com.qodr.lapakbekas.http.LifeSubscription;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.pedant.SweetAlert.SweetAlertDialog;
import rx.Subscription;

/**
 * Created by kodeartisan on 14/05/17.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    public static final String TAG = BaseActivity.class.getSimpleName();

    public final static List<AppCompatActivity> mActivities = new LinkedList<AppCompatActivity>();

    public SweetAlertDialog mProgressDialog;

    public static BaseActivity mActivity;

    private Unbinder unbinder;

    //protected T mPresenter;

    protected Subscription mSubscription;

    protected ActivityComponent mActivityComponent;

    protected abstract void initData();

    public abstract void initDagger();

    public abstract void initViewsAndListener();

    public abstract void initPresenter();

    public abstract void initToolbar();

    protected abstract int getLayoutId();

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityComponent();
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initDagger();
        initPresenter();
        initData();
        initToolbar();
        initViewsAndListener();
        /*if(mPresenter != null) {
            mPresenter.onCreate();
        }*/
    }

    private void initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(BaseApplication.getApplicationComponent())
                .build();
    }


    public void killAll() {
        List<AppCompatActivity> copy;
        synchronized (mActivities) {
            copy = new LinkedList<>(mActivities);
        }

        for(AppCompatActivity appCompatActivity : copy) {
            appCompatActivity.finish();
        }

        android.os.Process.killProcess(android.os.Process.myPid());
    }


    @Override
    protected void onResume() {
        super.onResume();
        mActivity = this;
    }
    @Override
    protected void onPause() {
        super.onPause();
        mActivity = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities) {
            mActivities.remove(this);
        }

     /*   if(mPresenter != null) {
            mPresenter.onDestroy();
        }
*/
        if(mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }

        if(unbinder != null) {
            unbinder.unbind();
        }
    }


    @Override
    public void showProgress(String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            mProgressDialog.getProgressHelper().setBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
            mProgressDialog.setCancelable(false);
        }
        mProgressDialog.setTitleText(message);
        mProgressDialog.show();

    }

    @Override
    public void showProgress(String message, int progress) {
        mProgressDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        mProgressDialog.getProgressHelper().setBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        mProgressDialog.setTitleText(message);
        mProgressDialog.setCancelable(false);
        mProgressDialog.getProgressHelper().setProgress(progress);
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        if(!isFinishing())
            Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void close() {
        finish();
    }
}
