package com.home.moviefinder.data.network.response;

import com.squareup.moshi.Json;

public class MoviesResponse {

    @Json(name="poster_path")
    private String poster;

    @Json(name = "original_title")
    private String originalTitle;

    public MoviesResponse(String poster, String originalTitle) {
        this.poster = poster;
        this.originalTitle = originalTitle;
    }

    public String getPoster() {
        return poster;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }
}
