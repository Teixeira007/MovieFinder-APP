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

import java.util.Arrays;
import java.util.List;

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

        //Configurando o recyclerView
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new ListMovieAdapter(criarMovie()));
    }

    private List<Movie> criarMovie(){
        return Arrays.asList(
                new Movie("Avatar"),
                new Movie("Adão Negro"),
                new Movie("The Flash"),
                new Movie("The Flash"),
                new Movie("The Flash"),
                new Movie("The Flash"),
                new Movie("The Flash"),
                new Movie("The Flash"),
                new Movie("The Flash"),
                new Movie("The Flash"),
                new Movie("The Flash"),
                new Movie("The Flash")
        );
    }
}
