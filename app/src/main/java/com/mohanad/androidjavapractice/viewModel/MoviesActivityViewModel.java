package com.mohanad.androidjavapractice.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mohanad.androidjavapractice.model.ResultsModel;
import com.mohanad.androidjavapractice.repository.MovieRepository;

import java.util.List;

public class MoviesActivityViewModel extends AndroidViewModel {

    private final MovieRepository repository;

    public MoviesActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new MovieRepository(application.getApplicationContext());
    }

    public void addMovie(ResultsModel movie){
        repository.addMovie(movie);
    }

    public void deleteMovie(ResultsModel movie){
        repository.deleteMovie(movie);
    }

    public LiveData<List<ResultsModel>> getMoviesFromDatabase(){
        return repository.getMoviesFromDatabase();
    }

    public LiveData<List<ResultsModel>> getMoviesFromApi(){
        return repository.getMoviesFromApi();
    }

}
