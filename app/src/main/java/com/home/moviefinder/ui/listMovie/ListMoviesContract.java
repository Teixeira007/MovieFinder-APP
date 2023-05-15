package com.home.moviefinder.ui.listMovie;

import com.home.moviefinder.data.model.Movie;

import java.util.List;

public interface ListMoviesContract {
    interface ListMoviesView{
        void showMovies(List<Movie> movies);
        void showError();
    }

    interface ListMoviesPresenter{
        void getMovies();
        void destruiView();
    }
}
