package com.home.moviefinder.ui.detailsMovie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.home.moviefinder.R;
import com.home.moviefinder.data.model.Movie;

public class DetailsActivity extends AppCompatActivity {



    public static  final String EXTRA_MOVIE = "EXTRA_MOVIE";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView textTitleMovie;
        textTitleMovie = findViewById(R.id.text_title_movie);

        final Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);

        textTitleMovie.setText(movie.getTitle());
    }
}