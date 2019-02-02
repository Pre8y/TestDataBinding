package com.learncode.testdatabinding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learncode.testdatabinding.R;
import com.learncode.testdatabinding.data.model.RepoModel;
import com.learncode.testdatabinding.databinding.RepoListItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    List<RepoModel> repoModels;
    public RepoAdapter(List<RepoModel> repoModels) {
        this.repoModels = repoModels;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RepoListItemBinding repoListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),R.layout.repo_list_item,
                parent, false );

        return new RepoViewHolder(repoListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
            holder.bind();
    }

    @Override
    public int getItemCount() {
        return repoModels.size();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder{
        RepoListItemBinding binding;
        public RepoViewHolder(RepoListItemBinding binding) {
            super(binding.getRoot());
            this.binding =  binding;
        }
        public void bind(){
            binding.setRepo(repoModels.get(getLayoutPosition()));

        }
    }
}
