package com.app.base.request;

import com.app.library.frame.request.IHttpApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by cample on 2018/6/12.
 */

public final class RetrofitApi implements IHttpApi {
    private Retrofit retrofit;

    public RetrofitApi() {

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient.build())
                .build();
    }

    @Override
    public <T> T create(Class<T> clasz) {
        return retrofit.create(clasz);
    }
}
