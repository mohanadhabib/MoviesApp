package com.mohanad.androidjavapractice.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohanad.androidjavapractice.model.ResultsModel;
import com.mohanad.androidjavapractice.databinding.ItemMovieBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.MoviesViewHolder> {

    List<ResultsModel> resultsModels;

    public MoviesRecyclerAdapter(List<ResultsModel> resultsModels){
        this.resultsModels = resultsModels;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemMovieBinding binding = ItemMovieBinding.inflate(layoutInflater,parent,false);
        return new MoviesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        ResultsModel model = resultsModels.get(position);
        holder.binding.movieName.setText(model.getTitle());
        holder.binding.movieDesc.setText(model.getOverview());
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+model.getPosterPath()).into(holder.binding.movieImg);
    }

    @Override
    public int getItemCount() {
        return resultsModels.size();
    }

    public static class MoviesViewHolder extends RecyclerView.ViewHolder{

        ItemMovieBinding binding;

        public MoviesViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
