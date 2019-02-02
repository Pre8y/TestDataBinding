package com.learncode.testdatabinding.network;

import com.learncode.testdatabinding.data.model.RepoApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepoApiService {

    @GET("search/repositories")
    Observable<RepoApiResponse> getRepos(@Query("q") String key);
}
