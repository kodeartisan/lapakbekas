package com.qodr.lapakbekas.mvp.presenter;

import android.support.v4.app.Fragment;

import com.qodr.lapakbekas.base.BasePresenter;

import java.util.HashMap;

/**
 * Created by kodeartisan on 15/05/17.
 */
public interface IMainPresenter extends BasePresenter {

    void replaceFragment(Fragment to, String tag, boolean isExpanded);
    void searchProduct(HashMap<String, String> data);

}
