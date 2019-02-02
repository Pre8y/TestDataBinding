package com.learncode.testdatabinding.diComponent.module;

import android.app.Application;

import com.learncode.testdatabinding.network.RepoApiService;
import com.learncode.testdatabinding.viewmodel.SearchRepoViewModelFactory;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class})
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }
    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }



}
