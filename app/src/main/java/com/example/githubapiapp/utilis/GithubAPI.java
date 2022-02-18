package com.example.githubapiapp.utilis;

import com.example.githubapiapp.model.GithubModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI {
    @GET("/users/{user}")
    Call<GithubModel> getUser(@Path("user") String user);
}
