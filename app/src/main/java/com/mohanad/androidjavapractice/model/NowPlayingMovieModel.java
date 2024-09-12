package com.mohanad.androidjavapractice.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NowPlayingMovieModel {

    @SerializedName("dates")
    private DatesModel dates;

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<ResultsModel> results;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private int totalResults;

    public NowPlayingMovieModel(){

    }

    public DatesModel getDates() {
        return dates;
    }

    public void setDates(DatesModel dates) {
        this.dates = dates;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<ResultsModel> getResults() {
        return results;
    }

    public void setResults(List<ResultsModel> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
