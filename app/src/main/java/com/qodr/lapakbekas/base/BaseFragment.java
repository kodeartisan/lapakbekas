package com.qodr.lapakbekas.base;

import android.support.v4.app.Fragment;

import com.qodr.lapakbekas.http.LifeSubscription;
import com.qodr.lapakbekas.http.Stateful;

import butterknife.Unbinder;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by kodeartisan on 14/05/17.
 */
public abstract class BaseFragment extends Fragment implements LifeSubscription, Stateful {

    private CompositeSubscription mCompositeSubscription;
    private Unbinder bind;

    protected abstract void initInject();
    protected abstract void loadData();
    protected abstract int getLayoutId();
    protected abstract void initView();


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



    @Override
    public void onDetach() {
        super.onDetach();
        if(bind != null) {
            bind.unbind();
        }

        if(mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
