package com.home.moviefinder.data.network.response;

import java.util.List;

public class MoviesResults {

    private final List<MoviesResponse> results;

    public MoviesResults(List<MoviesResponse> results) {
        this.results = results;
    }

    public List<MoviesResponse> getResults() {
        return results;
    }
}
