package com.qodr.lapakbekas.http.utils;

import com.qodr.lapakbekas.entity.Product;
import com.qodr.lapakbekas.entity.ProductRetrofitBody;
import com.qodr.lapakbekas.entity.ProductWrapper;
import com.qodr.lapakbekas.entity.User;
import com.qodr.lapakbekas.http.service.BukalapakService;

import java.util.Map;

import retrofit2.Call;
import rx.Observable;

/**
 * Created by kodeartisan on 14/05/17.
 */
public class RetrofitBukalapakUtils extends HttpUtils {
    private BukalapakService mBukalapakService;

    public RetrofitBukalapakUtils(BukalapakService bukalapakService) {
        this.mBukalapakService = bukalapakService;
    }

    public Observable<User> authenticate() {
        return mBukalapakService.authenticate();
    }

    public Call<ProductWrapper> fetchProducts(Map<String, String> options) {
        return mBukalapakService.getProducts(options);
    }
}
