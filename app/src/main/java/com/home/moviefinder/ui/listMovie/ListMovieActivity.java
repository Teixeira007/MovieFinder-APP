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

public class ListMovieActivity extends AppCompatActivity
        implements  ListMoviesContract.ListMoviesView{

    private RecyclerView recyclerView;
    private ListMovieAdapter listMovieAdapter;
    private Toolbar toolbar;
    private ListMoviesContract.ListMoviesPresenter presenter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);

       configurationToolBar();
       configurationAdapter();

       presenter = new ListMoviesPresenter(this);
       presenter.getMovies();

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


    @Override
    public void showMovies(List<Movie> movies) {
        listMovieAdapter.setMovies(movies);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Erro ao carregar lista de filmes", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruiView();
    }
}
