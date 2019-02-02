package com.learncode.testdatabinding.viewmodel;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.learncode.testdatabinding.data.model.RepoApiResponse;
import com.learncode.testdatabinding.data.model.RepoModel;
import com.learncode.testdatabinding.network.RepoApiService;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchRepoViewModel extends AndroidViewModel {
    RepoApiService repoApiService;
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    MutableLiveData<String> searchKey = new MutableLiveData<>();

    public MutableLiveData<String> getError() {
        return error;
    }

    MutableLiveData<String> error = new MutableLiveData<>();

    public MutableLiveData<List<RepoModel>> getRepos() {
        return repos;
    }

    MutableLiveData<List<RepoModel>> repos = new MutableLiveData<>();

    public MutableLiveData<String> getSearchKey() {
        return searchKey;
    }

    @Inject
    public SearchRepoViewModel(@NonNull Application application, RepoApiService repoApiService) {
        super(application);
        this.repoApiService = repoApiService;
        error.setValue(null);
        isLoading.setValue(false);
        repos.setValue(null);
    }

    public void search(View view) {
        if (!isLoading.getValue()) {
            isLoading.setValue(true);
            error.setValue(null);
            Toast.makeText(getApplication(), searchKey.getValue(), Toast.LENGTH_SHORT).show();

            repoApiService.getRepos(searchKey.getValue())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<RepoApiResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.e("RETROFIT", "disposable");
                        }

                        @Override
                        public void onNext(RepoApiResponse repoApiResponse) {
                            Log.e("RETROFIT", "response");
                            repos.setValue(repoApiResponse.getItems());
                            error.setValue(null);
                            isLoading.setValue(false);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("RETROFIT", "error");
                            error.setValue("Something went wrong" + e.getMessage());
                            isLoading.setValue(false);
                        }

                        @Override
                        public void onComplete() {
                            Log.e("RETROFIT", "complete");
                            isLoading.setValue(false);
                        }
                    });
        }
    }
}
