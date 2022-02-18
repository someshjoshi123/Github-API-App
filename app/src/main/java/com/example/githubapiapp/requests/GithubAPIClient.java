package com.example.githubapiapp.requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.githubapiapp.model.GithubModel;

import java.util.List;

import retrofit2.Call;

public class GithubAPIClient {
    private MutableLiveData<GithubModel> gUser;
    private static GithubAPIClient instance;

    public static GithubAPIClient getInstance() {
        if (instance == null) {
            instance = new GithubAPIClient();
        }
        return instance;
    }

    private GithubAPIClient() {
        gUser = new MutableLiveData<>();
    }

    /*public LiveData<GithubModel> getUser() {
        return gUser;
    }*/
}
