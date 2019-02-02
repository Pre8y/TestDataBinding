package com.learncode.testdatabinding.diComponent.component;

import com.learncode.testdatabinding.MainActivity;
import com.learncode.testdatabinding.diComponent.module.ApiModule;
import com.learncode.testdatabinding.diComponent.module.AppModule;
import com.learncode.testdatabinding.diComponent.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ViewModelModule.class})
public interface ApiComponent {
     void inject(MainActivity activity);
}
