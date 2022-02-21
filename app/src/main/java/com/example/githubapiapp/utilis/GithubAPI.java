package com.example.githubapiapp.utilis;

import com.example.githubapiapp.model.GitHubRepoModel;
import com.example.githubapiapp.model.GithubUserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI {
    @GET("/users/{user}")
    Call<GithubUserModel> getUser(@Path("user") String user);

    @GET("/users/{user}/repos")
    Call<List<GitHubRepoModel>> getRepos(@Path("user") String user);
}
