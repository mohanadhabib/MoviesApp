package com.mohanad.androidjavapractice.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "Movies")
public class ResultsModel {

    @Ignore
    @SerializedName("adult")
    private boolean adult;

    @Ignore
    @SerializedName("backdrop_path")
    private String backdropPath;

    @Ignore
    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @Ignore
    @SerializedName("original_language")
    private String originalLanguage;

    @Ignore
    @SerializedName("original_title")
    private String originalTitle;

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    private String overview;

    @Ignore
    @SerializedName("popularity")
    private double popularity;

    @ColumnInfo(name = "posterPath")
    @SerializedName("poster_path")
    private String posterPath;

    @Ignore
    @SerializedName("release_date")
    private String releaseDate;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    @Ignore
    @SerializedName("video")
    private boolean video;

    @Ignore
    @SerializedName("vote_average")
    private double voteAverage;

    @Ignore
    @SerializedName("vote_count")
    private int voteCount;

    public ResultsModel(){

    }

    public ResultsModel(int id, String title, String overview, String posterPath) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.posterPath = posterPath;
    }

    public ResultsModel(boolean adult, String backdropPath, List<Integer> genreIds, int id, String originalLanguage, String originalTitle, String overview, double popularity, String posterPath, String releaseDate, String title, boolean video, double voteAverage, int voteCount) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.genreIds = genreIds;
        this.id = id;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
