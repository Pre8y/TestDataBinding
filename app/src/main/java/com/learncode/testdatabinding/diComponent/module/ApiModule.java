package com.learncode.testdatabinding.diComponent.module;

import com.google.gson.Gson;
import com.learncode.testdatabinding.network.RepoApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {NetworkModule.class})
public class ApiModule {
    String mBaseUrl;

    public ApiModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @Singleton
    public RepoApiService provideRepoApiService(Retrofit retrofit){
        return retrofit.create(RepoApiService.class);
    }
    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson){
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient);
            return builder.build();
    }

}
