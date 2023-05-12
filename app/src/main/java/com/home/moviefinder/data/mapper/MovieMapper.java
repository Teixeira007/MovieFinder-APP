package com.home.moviefinder.data.mapper;

import com.home.moviefinder.data.model.Movie;
import com.home.moviefinder.data.network.response.MoviesResponse;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {

    public static List<Movie> fromResponseforDomain(List<MoviesResponse> moviesResponses){

        List<Movie> listMovies = new ArrayList<>();

        for(MoviesResponse movieResponse: moviesResponses){
            final Movie movie = new Movie(movieResponse.getOriginalTitle(), movieResponse.getPoster());
            listMovies.add(movie);
        }

        return listMovies;
    }
}
