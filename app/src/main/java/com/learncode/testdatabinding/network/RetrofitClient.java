package com.learncode.testdatabinding.network;

import android.content.Context;

import com.google.gson.Gson;


import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitClient {
    private static Retrofit retrofit;

    private RetrofitClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Provides
    public static Retrofit getRetrofit(){
        if(retrofit==null){
            OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
            httpBuilder.addInterceptor(new HttpLoggingInterceptor());
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpBuilder.build());
            retrofit = builder.build();
        }
        return retrofit;
    }
}
