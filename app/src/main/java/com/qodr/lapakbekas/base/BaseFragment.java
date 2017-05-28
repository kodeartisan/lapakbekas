package com.qodr.lapakbekas.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qodr.lapakbekas.R;
import com.qodr.lapakbekas.di.component.DaggerFragmentComponent;
import com.qodr.lapakbekas.di.component.FragmentComponent;
import com.qodr.lapakbekas.http.LifeSubscription;
import com.qodr.lapakbekas.http.Stateful;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.pedant.SweetAlert.SweetAlertDialog;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by kodeartisan on 14/05/17.
 */
public abstract class BaseFragment extends Fragment implements LifeSubscription, Stateful, BaseView {

    private BaseActivity mActivity;
    private CompositeSubscription mCompositeSubscription;
    private Unbinder unbinder;
    public FragmentComponent mFragmentComponent;
    public SweetAlertDialog mProgressDialog;
    protected abstract void initDagger();
    protected abstract int getLayoutId();
    protected abstract void initView();
    public abstract void initData();
    public abstract void initPresenter();


    @Override
    public void bindSubscription(Subscription subscription) {
        if(mCompositeSubscription == null) {
           mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void setState(int state) {

    }

    private View getCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layoutView = getCreateView(inflater,container);
        unbinder = ButterKnife.bind(this, layoutView);

        return layoutView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mFragmentComponent = DaggerFragmentComponent
                .builder()
                .activityComponent(getBaseActivity().getActivityComponent())
                .build();
        initDagger();
        initView();
        initPresenter();
        initData();
        super.onViewCreated(view, savedInstanceState);
    }

    public BaseActivity getBaseActivity() {
        if (mActivity == null) {
            mActivity = (BaseActivity) getActivity();
        }
        return mActivity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder != null) {
            unbinder.unbind();
        }
    }
}
