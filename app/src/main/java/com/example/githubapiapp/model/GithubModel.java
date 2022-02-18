package com.example.githubapiapp.model;

import com.google.gson.annotations.SerializedName;

public class GithubModel {
    private String login;
    private String avatar_url;
    private String name;
    private int public_repos;
    private int followers;
    private int following;

    public GithubModel(String login, String avatar_url, String name, int public_repos, int followers, int following) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.name = name;
        this.public_repos = public_repos;
        this.followers = followers;
        this.following = following;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getName() {
        return name;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }
}
