package com.mohanad.androidjavapractice.repository;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mohanad.androidjavapractice.constant.Constant;
import com.mohanad.androidjavapractice.model.NowPlayingMovieModel;
import com.mohanad.androidjavapractice.model.ResultsModel;
import com.mohanad.androidjavapractice.service.ApiService;
import com.mohanad.androidjavapractice.service.NowPlayingMovieDatabase;
import com.mohanad.androidjavapractice.service.RetrofitService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private final Context context;
    private final ExecutorService executor;

    public MovieRepository(Context context){
        this.context = context;
        executor = Executors.newSingleThreadExecutor();
    }

    public void addMovie(ResultsModel movie){
        executor.execute(() -> NowPlayingMovieDatabase.getDatabase(context).getNowPlayingMovieDao().addMovie(movie));
    }

    public void deleteMovie(ResultsModel movie){
        executor.execute(() -> NowPlayingMovieDatabase.getDatabase(context).getNowPlayingMovieDao().deleteMovie(movie));
    }

    public LiveData<List<ResultsModel>> getMoviesFromDatabase(){
        return NowPlayingMovieDatabase.getDatabase(context).getNowPlayingMovieDao().getMovies();
    }

    public LiveData<List<ResultsModel>> getMoviesFromApi(){
        MutableLiveData<List<ResultsModel>> movies = new MutableLiveData<>();
        RetrofitService.getRetrofit()
                .create(ApiService.class)
                .getNowPlayingMovies(Constant.AUTH_KEY)
                .enqueue(new Callback<NowPlayingMovieModel>() {
                    @Override
                    public void onResponse(@NonNull Call<NowPlayingMovieModel> call, @NonNull Response<NowPlayingMovieModel> response) {
                        assert response.body() != null;
                        movies.setValue(response.body().getResults());
                    }

                    @Override
                    public void onFailure(@NonNull Call<NowPlayingMovieModel> call, @NonNull Throwable throwable) {
                        Toast.makeText(context, throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        return movies;
    }
}
