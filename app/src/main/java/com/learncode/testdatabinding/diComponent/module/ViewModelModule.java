package com.learncode.testdatabinding.diComponent.module;

import com.learncode.testdatabinding.diComponent.ViewModelKey;
import com.learncode.testdatabinding.viewmodel.SearchRepoViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchRepoViewModel.class)
    abstract SearchRepoViewModel bindSearchRepoViewModel(SearchRepoViewModel searchRepoViewModel);
}