package com.mohanad.androidjavapractice.service;

import com.mohanad.androidjavapractice.model.NowPlayingMovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiService {
    @GET("movie/now_playing")
    Call<NowPlayingMovieModel> getNowPlayingMovies(@Header("Authorization") String authKey);
}
