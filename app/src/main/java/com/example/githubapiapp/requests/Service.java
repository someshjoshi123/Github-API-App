package com.example.githubapiapp.requests;

import com.example.githubapiapp.utilis.Credentials;
import com.example.githubapiapp.utilis.GithubAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static GithubAPI githubAPI = retrofit.create(GithubAPI.class);

    public static GithubAPI getGithubAPI() {
        return githubAPI;
    }
}
