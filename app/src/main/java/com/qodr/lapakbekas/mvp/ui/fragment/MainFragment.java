package com.qodr.lapakbekas.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qodr.lapakbekas.R;
import com.qodr.lapakbekas.mvp.ui.adapter.FragmentPageAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kodeartisan on 25/05/17.
 */

public class MainFragment extends Fragment {

    @BindView(R.id.tab_home)
    TabLayout mTabLayout;

    @BindView(R.id.viewpager_home)
    ViewPager mViewPager;

    private ArrayList<String> mTitleList = new ArrayList<>(3);
    private ArrayList<Fragment> mFragments = new ArrayList<>(3);
    private FragmentPageAdapter mAdapter;
    private View inflate;

    public static final String TAG = MainFragment.class.getSimpleName();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (inflate == null) {
            inflate = inflater.inflate(R.layout.fragment_main, null);
            ButterKnife.bind(this, inflate);
        }
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragmentList();
        mAdapter = new FragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setupWithViewPager(mViewPager);


    }

    private void initFragmentList() {
        if (mTitleList.size() != 0) {
            return;
        }
        mTitleList.add("HOME");
        mTitleList.add("KATEGORI");
        mTitleList.add("TROLI");
        mFragments.add(new HomeFragment().newInstance());
        mFragments.add(new HomeFragment().newInstance());
        mFragments.add(new HomeFragment().newInstance());


    }
}
