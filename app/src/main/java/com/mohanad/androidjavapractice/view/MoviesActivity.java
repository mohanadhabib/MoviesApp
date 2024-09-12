package com.mohanad.androidjavapractice.view;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.mohanad.androidjavapractice.adapter.MoviesRecyclerAdapter;
import com.mohanad.androidjavapractice.constant.Constant;
import com.mohanad.androidjavapractice.databinding.ActivityMoviesBinding;
import com.mohanad.androidjavapractice.model.ResultsModel;
import com.mohanad.androidjavapractice.viewModel.MoviesActivityViewModel;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity {

    ActivityMoviesBinding binding;
    MoviesActivityViewModel viewModel;
    ArrayList<ResultsModel> results;
    MoviesRecyclerAdapter adapter;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoviesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(Constant.STORAGE_SHARED_PREFERENCE,0);
        editor = sharedPreferences.edit();

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        viewModel = new ViewModelProvider(this).get(MoviesActivityViewModel.class);

        if(!sharedPreferences.getBoolean(Constant.SAVED_FLAG, false)){
            viewModel.getMoviesFromApi().observe(this,model -> {
                results = (ArrayList<ResultsModel>) model;
                for(ResultsModel result : results){
                    viewModel.addMovie(result);
                }
                editor.putBoolean(Constant.SAVED_FLAG,true).commit();
                adapter = new MoviesRecyclerAdapter(model);
                binding.recyclerView.setAdapter(adapter);
            });
        }
        else {
            viewModel.getMoviesFromDatabase().observe(this,resultsModels -> {
                results = (ArrayList<ResultsModel>) resultsModels;
                adapter = new MoviesRecyclerAdapter(resultsModels);
                binding.recyclerView.setAdapter(adapter);
            });
        }

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                ResultsModel model = results.get(pos);
                viewModel.deleteMovie(model);
            }
        }).attachToRecyclerView(binding.recyclerView);
    }
}