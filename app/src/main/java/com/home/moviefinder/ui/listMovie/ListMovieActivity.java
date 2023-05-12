package com.home.moviefinder.ui.listMovie;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.home.moviefinder.R;
import com.home.moviefinder.data.model.Movie;
import com.home.moviefinder.data.network.ApiService;
import com.home.moviefinder.data.network.response.MoviesResults;

import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMovieActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        recyclerView = findViewById(R.id.my_recyclerView);
        ApiService.getIntance()
                .getListMoviesPopular("df11c6ebfaff4552cd4ceb4187f105fb")
                .enqueue(new Callback<MoviesResults>() {
                    @Override
                    public void onResponse(Call<MoviesResults> call, Response<MoviesResults> response) {
                        if(response.isSuccessful()){
                            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListMovieActivity.this);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(new ListMovieAdapter(response.body().getResults()));
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesResults> call, Throwable t) {

                    }
                });

        //Configurando o recyclerView

    }


}
