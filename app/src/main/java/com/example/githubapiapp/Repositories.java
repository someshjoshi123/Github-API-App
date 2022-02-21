package com.example.githubapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.githubapiapp.adapter.RepoAdapter;
import com.example.githubapiapp.model.GitHubRepoModel;
import com.example.githubapiapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class Repositories extends AppCompatActivity {

    RecyclerView recyclerView;
    RepoAdapter repoAdapter;
    List<GitHubRepoModel> repoModel = new ArrayList<>();
    UserViewModel userViewModel;
    String userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);

        Bundle extra = getIntent().getExtras();
        userLogin = extra.getString("userLogin");

        ConfigureRecyclerView();
        LoadRepositories();
    }

    private void LoadRepositories() {
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getRepository().observe(this, new Observer<List<GitHubRepoModel>>() {
            @Override
            public void onChanged(List<GitHubRepoModel> gitHubRepoModels) {
                if (gitHubRepoModels != null) {
                    repoModel.clear();
                    repoModel.addAll(gitHubRepoModels);
                    repoAdapter.notifyDataSetChanged();
                }
            }
        });
        userViewModel.CallRepository(userLogin);
    }

    private void ConfigureRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        repoAdapter = new RepoAdapter(repoModel, R.layout.repo_list_item, getApplicationContext());
        recyclerView.setAdapter(repoAdapter);
    }
}