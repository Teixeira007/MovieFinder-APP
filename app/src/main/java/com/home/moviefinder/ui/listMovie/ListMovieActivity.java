package com.home.moviefinder.ui.listMovie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.home.moviefinder.R;
import com.home.moviefinder.data.mapper.MovieMapper;
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
    private ListMovieAdapter listMovieAdapter;
    private Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);

       configurationToolBar();
       configurationAdapter();
       getMovies();

    }

    private void configurationToolBar(){
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    private void configurationAdapter(){
        recyclerView = findViewById(R.id.my_recyclerView);

        listMovieAdapter = new ListMovieAdapter();

        RecyclerView.LayoutManager gridLayout = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayout);
        recyclerView.setAdapter(listMovieAdapter);
    }

    private void getMovies(){
        ApiService.getIntance()
            .getListMoviesPopular("df11c6ebfaff4552cd4ceb4187f105fb")
            .enqueue(new Callback<MoviesResults>() {
                @Override
                public void onResponse(Call<MoviesResults> call, Response<MoviesResults> response) {
                    if(response.isSuccessful()){
                        final List<Movie> movies = MovieMapper.fromResponseforDomain(response.body().getResults());
                        listMovieAdapter.setMovies(movies);
                    }else{
                        messageError();
                    }
                }

                @Override
                public void onFailure(Call<MoviesResults> call, Throwable t) {
                    messageError();
                }
            });
    }

    private void messageError(){
        Toast.makeText(this, "Erro ao carregar lista de filmes", Toast.LENGTH_SHORT).show();
    }


}
