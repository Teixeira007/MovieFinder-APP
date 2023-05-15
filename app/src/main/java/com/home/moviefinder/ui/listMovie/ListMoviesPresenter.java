package com.home.moviefinder.ui.listMovie;

import com.home.moviefinder.data.mapper.MovieMapper;
import com.home.moviefinder.data.model.Movie;
import com.home.moviefinder.data.network.ApiService;
import com.home.moviefinder.data.network.response.MoviesResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMoviesPresenter implements  ListMoviesContract.ListMoviesPresenter{

    private ListMoviesContract.ListMoviesView view;

    public ListMoviesPresenter(ListMoviesContract.ListMoviesView view) {
        this.view = view;
    }

    @Override
    public void getMovies() {
        ApiService.getIntance()
            .getListMoviesPopular("df11c6ebfaff4552cd4ceb4187f105fb")
            .enqueue(new Callback<MoviesResults>() {
                @Override
                public void onResponse(Call<MoviesResults> call, Response<MoviesResults> response) {
                    if(response.isSuccessful()){
                        final List<Movie> movies = MovieMapper.fromResponseforDomain(response.body().getResults());
                        view.showMovies(movies);
                    }else{
                        view.showError();
                    }
                }

                @Override
                public void onFailure(Call<MoviesResults> call, Throwable t) {
                    view.showError();
                }
            });
    }

    @Override
    public void destruiView() {
        this.view = null;
    }
}
