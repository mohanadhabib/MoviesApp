package com.mohanad.androidjavapractice.service;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mohanad.androidjavapractice.model.ResultsModel;

@Database(entities = {ResultsModel.class} , version = 1)
public abstract class NowPlayingMovieDatabase extends RoomDatabase {

    public abstract NowPlayingMovieDao getNowPlayingMovieDao();

    private static NowPlayingMovieDatabase database;

    public static NowPlayingMovieDatabase getDatabase(Context context){
        if (database == null){
            database = Room
                    .databaseBuilder(context,NowPlayingMovieDatabase.class,"Now Playing Movie Database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
}
