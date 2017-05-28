package com.qodr.lapakbekas.event;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.qodr.lapakbekas.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kodeartisan on 27/05/17.
 */

public class ProductEvent {

    public Product mProduct;

    public List<Product> mProductList = new ArrayList<>();

    public int mAction;

    public ProductEvent(@Nullable Product product, @Nullable List<Product> list, @NonNull int action) {
        this.mAction = action;
        this.mProduct = product;
        this.mProductList = list;
    }
}
