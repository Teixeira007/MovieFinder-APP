package com.home.moviefinder.movie;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.home.moviefinder.R;

public class MovieActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
    }
}
