package com.example.githubapiapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.githubapiapp.model.GitHubRepoModel;
import com.example.githubapiapp.model.GithubUserModel;
import com.example.githubapiapp.requests.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {

    MutableLiveData<GithubUserModel> user;
    MutableLiveData<List<GitHubRepoModel>> repository;

    public UserViewModel() {
        user = new MutableLiveData<>();
        repository = new MutableLiveData<>();
    }

    public MutableLiveData<GithubUserModel> getUserData() {
        return user;
    }

    public MutableLiveData<List<GitHubRepoModel>> getRepository() {
        return repository;
    }

    public void CallUser(String name) {
        Call<GithubUserModel> call = Service.getGithubAPI().getUser(name);

        call.enqueue(new Callback<GithubUserModel>() {
            @Override
            public void onResponse(Call<GithubUserModel> call, Response<GithubUserModel> response) {
                user.postValue(response.body());
            }

            @Override
            public void onFailure(Call<GithubUserModel> call, Throwable t) {
                user.postValue(null);
            }
        });
    }

    public void CallRepository(String name) {
        Call<List<GitHubRepoModel>> call = Service.getGithubAPI().getRepos(name);

        call.enqueue(new Callback<List<GitHubRepoModel>>() {
            @Override
            public void onResponse(Call<List<GitHubRepoModel>> call, Response<List<GitHubRepoModel>> response) {
                repository.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<GitHubRepoModel>> call, Throwable t) {
                repository.postValue(null);
            }
        });
    }
}
