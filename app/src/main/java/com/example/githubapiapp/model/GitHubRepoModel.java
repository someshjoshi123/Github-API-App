package com.example.githubapiapp.model;

import java.util.Date;

public class GitHubRepoModel {
    private String name;
    private Date updated_at;
    private String language;
    private int stargazers_count;
    private int forks_count;

    public GitHubRepoModel(String name, Date updated_at, String language, int stargazers_count, int forks_count) {
        this.name = name;
        this.updated_at = updated_at;
        this.language = language;
        this.stargazers_count = stargazers_count;
        this.forks_count = forks_count;
    }

    public String getName() {
        return name;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getLanguage() {
        return language;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public int getForks_count() {
        return forks_count;
    }
}
