package com.home.moviefinder.data.network;


import com.home.moviefinder.data.network.response.MoviesResults;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesService {

    @GET("movie/popular")
    Call<MoviesResults> getListMoviesPopular(@Query("api_key") String keyPrimary);

}
