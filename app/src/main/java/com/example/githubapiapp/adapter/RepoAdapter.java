package com.example.githubapiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubapiapp.R;
import com.example.githubapiapp.model.GitHubRepoModel;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.Viewholder> {

    private List<GitHubRepoModel>repoModels;
    private Context context;
    private int repo_list_item;

    public RepoAdapter(List<GitHubRepoModel> repoModels, int repo_list_item, Context context) {
        this.repoModels = repoModels;
        this.context = context;
        this.repo_list_item = repo_list_item;
    }

    @NonNull
    @Override
    public RepoAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(repo_list_item,parent,false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoAdapter.Viewholder holder, int position) {
        GitHubRepoModel repoModel = repoModels.get(position);
        holder.repo_name.setText(repoModel.getName());
        holder.last_updated.setText(repoModel.getUpdated_at().toString());
        holder.language.setText(repoModel.getLanguage());
        holder.stars.setText(String.valueOf(repoModel.getStargazers_count()));
        holder.forks.setText(String.valueOf(repoModel.getForks_count()));
    }

    @Override
    public int getItemCount() {
        return repoModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        AppCompatTextView repo_name, last_updated, language, stars, forks;
        LinearLayoutCompat repo_list_item;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            repo_list_item = itemView.findViewById(R.id.repo_list_item);
            repo_name = itemView.findViewById(R.id.repo_name);
            last_updated = itemView.findViewById(R.id.last_updated);
            language = itemView.findViewById(R.id.language);
            stars = itemView.findViewById(R.id.stars);
            forks = itemView.findViewById(R.id.forks);
        }
    }
}
