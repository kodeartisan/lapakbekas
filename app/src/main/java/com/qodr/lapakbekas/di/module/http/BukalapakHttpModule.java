package com.qodr.lapakbekas.di.module.http;

import android.util.Log;

import com.qodr.lapakbekas.di.qualifier.BukalapakUrl;
import com.qodr.lapakbekas.http.service.BukalapakService;
import com.qodr.lapakbekas.http.utils.RetrofitBukalapakUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kodeartisan on 14/05/17.
 */
@Module
public class BukalapakHttpModule extends BaseHttpModule {

    public static final String TAG = BukalapakHttpModule.class.getSimpleName();

    @Singleton
    @Provides
    @BukalapakUrl
    Retrofit provideBukalapakRetrofit(Retrofit.Builder retrofitBuilder, OkHttpClient.Builder okhttpBuilder, OkHttpClient client) {

        return retrofitBuilder
                .client(client)
                .baseUrl(BukalapakService.API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    BukalapakService provideBukalapakService(@BukalapakUrl Retrofit retrofit) {
        return retrofit.create(BukalapakService.class);
    }

    @Singleton
    @Provides
    RetrofitBukalapakUtils provideRetrofitBukalapakUtils(BukalapakService bukalapakService) {
        return new RetrofitBukalapakUtils(bukalapakService);
    }


}
