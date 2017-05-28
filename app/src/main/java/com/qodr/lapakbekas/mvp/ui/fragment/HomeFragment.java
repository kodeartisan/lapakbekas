package com.qodr.lapakbekas.mvp.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.qodr.lapakbekas.R;
import com.qodr.lapakbekas.base.BaseFragment;
import com.qodr.lapakbekas.base.BaseView;
import com.qodr.lapakbekas.entity.Product;
import com.qodr.lapakbekas.event.EventConstant;
import com.qodr.lapakbekas.event.ProductEvent;
import com.qodr.lapakbekas.event.SearchProductEvent;
import com.qodr.lapakbekas.mvp.presenter.impl.HomeFragmentPresenterImpl;
import com.qodr.lapakbekas.mvp.ui.adapter.ProductAdapter;
import com.qodr.lapakbekas.mvp.view.IHomeFragmentView;
import com.qodr.lapakbekas.rx.RxBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by kodeartisan on 25/05/17.
 */

public class HomeFragment extends BaseFragment implements IHomeFragmentView, BaseView,
        RecyclerArrayAdapter.OnLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener,
        RecyclerArrayAdapter.OnItemClickListener
{

    public static final String TAG = HomeFragment.class.getSimpleName();

    private List<Product> mProductList = new ArrayList<>();
    private ProductAdapter mAdapter;

    @Inject
    HomeFragmentPresenterImpl mPresenter;

    @Inject
    RxBus mRxBus;

    @BindView(R.id.easyRecyclerView)
    EasyRecyclerView mEasyRecylerview;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected void initDagger() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        initRecylerview();
    }

    @Override
    public void initData() {
        HashMap<String, String> data = new HashMap<>();

        mPresenter.fetchProducts(data);

        Subscription fetchProductSubscription = mRxBus.toObservable(ProductEvent.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ProductEvent>() {
                    @Override
                    public void call(ProductEvent productEvent) {
                        switch (productEvent.mAction) {
                            case EventConstant.ADD:
                                mProductList.clear();
                                mAdapter.clear();
                                mProductList = productEvent.mProductList;
                                mAdapter.addAll(mProductList);

                                break;
                            default:
                                break;
                        }

                       // mAdapter.notifyDataSetChanged();
                    }
                });

        Subscription searchProductSubscription = mRxBus.toObservable(SearchProductEvent.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SearchProductEvent>() {
                    @Override
                    public void call(SearchProductEvent searchProductEvent) {
                        Log.d(TAG, searchProductEvent.getQueryData().get("keywords"));
                         mPresenter.fetchProducts(searchProductEvent.getQueryData());
                    }
                });

        bindSubscription(searchProductSubscription);
        bindSubscription(fetchProductSubscription);
    }

    private void initRecylerview() {
        mAdapter = new ProductAdapter(getActivity(), mProductList);
        mAdapter.setMore(R.layout.layout_load_more, this);
        mAdapter.setOnItemClickListener(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mEasyRecylerview.setLayoutManager(gridLayoutManager);
        mEasyRecylerview.setAdapter(mAdapter);
        mEasyRecylerview.setRefreshListener(this);

    }

    @Override
    public void initPresenter() {
        mPresenter.attachView(this);
    }

    @Override
    public void showProgress() {
        mEasyRecylerview.showProgress();
    }

    @Override
    public void showError() {
        mEasyRecylerview.showError();
    }

    @Override
    public void showEmpty() {
        mEasyRecylerview.showEmpty();
    }

    @Override
    public void onCompleted() {
        mEasyRecylerview.setRefreshing(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    @Override
    public void onLoadMore() {
        mEasyRecylerview.showProgress();
        Log.d(TAG, "load more");
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(int position) {

    }
}
