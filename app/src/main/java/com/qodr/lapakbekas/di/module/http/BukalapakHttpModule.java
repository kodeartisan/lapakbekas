package com.qodr.lapakbekas.di.module.http;

import com.qodr.lapakbekas.di.qualifier.BukalapakUrl;
import com.qodr.lapakbekas.http.service.BukalapakService;
import com.qodr.lapakbekas.http.utils.BasicAuthInterceptor;
import com.qodr.lapakbekas.http.utils.RetrofitBukalapakUtils;

import java.util.concurrent.TimeUnit;

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

    @Singleton
    @Provides
    @BukalapakUrl
    Retrofit provideBukalapakRetrofit(Retrofit.Builder retrofitBuilder, OkHttpClient.Builder okhttpBuilder, OkHttpClient client, BasicAuthInterceptor basicAuthInterceptor) {
        OkHttpClient okHttpClient = okhttpBuilder.addInterceptor(basicAuthInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        return retrofitBuilder
                .baseUrl(BukalapakService.API_URL)
                .client(okHttpClient)
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
