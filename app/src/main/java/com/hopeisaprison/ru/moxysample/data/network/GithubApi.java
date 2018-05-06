package com.hopeisaprison.ru.moxysample.data.network;

import com.hopeisaprison.ru.moxysample.data.network.model.Repository;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {

    @GET("/users/{user}/repos")
    Single<List<Repository>> getRepos(@Path("user")String user);

}
