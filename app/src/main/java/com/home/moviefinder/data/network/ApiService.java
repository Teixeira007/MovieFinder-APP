package com.home.moviefinder.data.network;


import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    private static MoviesService INSTANCE;

    public static MoviesService getIntance(){
        if(INSTANCE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
            INSTANCE = retrofit.create(MoviesService.class);
        }
        return INSTANCE;
    }



}
