package com.qodr.lapakbekas.mvp.presenter;

import com.qodr.lapakbekas.base.BasePresenter;

import java.util.Map;

/**
 * Created by kodeartisan on 25/05/17.
 */

public interface IHomeFragmentPresenter extends BasePresenter {

    void fetchProducts(Map<String, String> options);
}
