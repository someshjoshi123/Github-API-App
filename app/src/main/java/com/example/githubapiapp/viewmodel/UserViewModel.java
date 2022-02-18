package com.example.githubapiapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.githubapiapp.model.GithubModel;
import com.example.githubapiapp.requests.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {

    MutableLiveData<GithubModel> user;

    public UserViewModel() {
        user = new MutableLiveData<>();
    }

    public MutableLiveData<GithubModel> getUserData() {
        return user;
    }

    public void CallUser(String name) {
        Call<GithubModel> call = Service.getGithubAPI().getUser(name);

        call.enqueue(new Callback<GithubModel>() {
            @Override
            public void onResponse(Call<GithubModel> call, Response<GithubModel> response) {
                user.postValue(response.body());
            }

            @Override
            public void onFailure(Call<GithubModel> call, Throwable t) {
                user.postValue(null);
            }
        });
    }
}
