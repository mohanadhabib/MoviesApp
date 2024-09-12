package com.mohanad.androidjavapractice.service;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.mohanad.androidjavapractice.model.ResultsModel;

import java.util.List;

@Dao
public interface NowPlayingMovieDao {

    @Insert
    void addMovie(ResultsModel movie);

    @Delete
    void deleteMovie(ResultsModel movie);

    @Query("SELECT * FROM Movies")
    LiveData<List<ResultsModel>> getMovies();
}
