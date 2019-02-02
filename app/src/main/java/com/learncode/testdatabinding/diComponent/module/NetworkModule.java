package com.learncode.testdatabinding.diComponent.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor){
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        httpBuilder.addInterceptor(loggingInterceptor);
        return httpBuilder.build();
    }
    @Provides
    @Singleton
    public HttpLoggingInterceptor provideLoggingInterceptor(){
        return new HttpLoggingInterceptor();
    }
}
