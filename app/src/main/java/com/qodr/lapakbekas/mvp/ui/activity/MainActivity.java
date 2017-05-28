package com.qodr.lapakbekas.mvp.ui.activity;


import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.qodr.lapakbekas.R;
import com.qodr.lapakbekas.base.BaseActivity;
import com.qodr.lapakbekas.base.BaseView;
import com.qodr.lapakbekas.http.utils.RetrofitBukalapakUtils;
import com.qodr.lapakbekas.mvp.presenter.impl.MainPresenterImpl;
import com.qodr.lapakbekas.mvp.ui.adapter.FragmentPageAdapter;
import com.qodr.lapakbekas.mvp.ui.fragment.HomeFragment;
import com.qodr.lapakbekas.mvp.ui.fragment.MainFragment;
import com.qodr.lapakbekas.mvp.view.IHomeView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements IHomeView, BaseView {

    public static final String TAG = MainActivity.class.getSimpleName();

    HomeFragment mHomeFragment;

    @Inject
    MainPresenterImpl mMainPresenter;

    @Inject
    RetrofitBukalapakUtils mRetrofitDoubanUtils;

    @BindView(R.id.fl_title_menu)
    FrameLayout mNavMenu;

    @BindView(R.id.bottom_bar)
    BottomBar mBottombar;

    @BindView(R.id.dl_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.view_search)
    MaterialSearchView mSearchView;



    @Override
    protected void initData() {

    }

    @Override
    public void initDagger() {
        mActivityComponent.inject(this);
    }

    @Override
    public void initViewsAndListener() {

        initSearch();
        initBottombarListener();
        mHomeFragment = HomeFragment.newInstance();
        mMainPresenter.replaceFragment(mHomeFragment, HomeFragment.TAG, true);

    }

    @Override
    public void initPresenter() {
        mMainPresenter.attachView(this);
    }

    @Override
    public void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        mSearchView.setMenuItem(item);
        return true;
    }

    private void initSearch() {
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                HashMap<String, String> data = new HashMap<String, String>();
                data.put("keywords", query);
                data.put("conditions", "used");
                mMainPresenter.searchProduct(data);
                return  false;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                return false;
            }
        });
    }

    private void initBottombarListener() {
        mBottombar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void onCompleted() {

    }
}
