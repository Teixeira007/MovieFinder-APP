package com.home.moviefinder.data.model;

import java.io.Serializable;

public class Movie  implements Serializable {
    private String title;
    private String posterImage;

    public Movie(String title, String posterImage) {
        this.title = title;
        this.posterImage = posterImage;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterImage() {
        return posterImage;
    }
}
