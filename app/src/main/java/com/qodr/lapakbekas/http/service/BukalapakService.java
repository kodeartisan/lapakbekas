package com.qodr.lapakbekas.http.service;

import com.qodr.lapakbekas.entity.Product;
import com.qodr.lapakbekas.entity.ProductRetrofitBody;
import com.qodr.lapakbekas.entity.ProductWrapper;
import com.qodr.lapakbekas.entity.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by kodeartisan on 14/05/17.
 */
public interface BukalapakService {

    String API_URL = "https://api.bukalapak.com/v2/";


    @POST("/authenticate.json")
    Observable<User> authenticate();

    @GET("products.json")
    Call<ProductWrapper> getProducts(@QueryMap Map<String, String> options);
}
