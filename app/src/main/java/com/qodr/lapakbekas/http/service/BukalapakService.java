package com.qodr.lapakbekas.http.service;

import com.qodr.lapakbekas.entity.User;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by kodeartisan on 14/05/17.
 */
public interface BukalapakService {

    String API_URL = "https://api.bukalapak.com/v2";


    @POST("/authenticate.json")
    Observable<User> authenticate();

}
