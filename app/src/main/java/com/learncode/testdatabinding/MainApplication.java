package com.learncode.testdatabinding;

import android.app.Application;

import com.learncode.testdatabinding.diComponent.component.ApiComponent;
import com.learncode.testdatabinding.diComponent.module.ApiModule;
import com.learncode.testdatabinding.diComponent.module.AppModule;

public class MainApplication extends Application {
    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
//        DaggerApi
//        apiComponent = DaggerApiComponent.builder()
//                .appModule(new AppModule(this))
//                .apiModule(new ApiModule("https://api.github.com"))
//                .build();
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
