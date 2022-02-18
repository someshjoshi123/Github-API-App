package com.example.githubapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.githubapiapp.model.GithubModel;
import com.example.githubapiapp.viewmodel.UserViewModel;

public class UserDetails extends AppCompatActivity {

    AppCompatImageView avatar;
    AppCompatTextView name, login, publicrepos, followers, following;
    AppCompatButton repos;
    Bundle extra;
    String userLogin;
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        avatar = findViewById(R.id.avatar);
        name = findViewById(R.id.name);
        login = findViewById(R.id.login);
        publicrepos = findViewById(R.id.publicrepos);
        followers = findViewById(R.id.followers);
        following = findViewById(R.id.following);
        repos = findViewById(R.id.repos);

        extra = getIntent().getExtras();
        userLogin = extra.getString("userLogin");

        loadUserDetails();
    }

    private void loadUserDetails() {
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUserData().observe(this, new Observer<GithubModel>() {
            @Override
            public void onChanged(GithubModel githubModel) {
                if (githubModel != null) {
                    Glide.with(getApplicationContext())
                            .load(githubModel.getAvatar_url())
                            .into(avatar);

                    if (githubModel.getName() == null) {
                        name.setText("No Name provided");
                    }
                    else {
                        name.setText("Name: " + githubModel.getName());
                    }

                    login.setText("Login ID: " + githubModel.getLogin());
                    publicrepos.setText("Repositories: " + githubModel.getPublic_repos());
                    followers.setText("Followers: " + githubModel.getFollowers());
                    following.setText("Following: " + githubModel.getFollowing());

                }
            }
        });
        userViewModel.CallUser(userLogin);
    }
}