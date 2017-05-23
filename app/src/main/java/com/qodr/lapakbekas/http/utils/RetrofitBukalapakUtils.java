package com.qodr.lapakbekas.http.utils;

import com.qodr.lapakbekas.entity.User;
import com.qodr.lapakbekas.http.service.BukalapakService;

import rx.Observable;

/**
 * Created by kodeartisan on 14/05/17.
 */
public class RetrofitBukalapakUtils extends HttpUtils {
    private BukalapakService mBukalapakService;

    public RetrofitBukalapakUtils(BukalapakService bukalapakService) {
        this.mBukalapakService = mBukalapakService;
    }

    public Observable<User> authenticate() {
        return mBukalapakService.authenticate();
    }
}
