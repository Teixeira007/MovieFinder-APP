package com.home.moviefinder.ui.listMovie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.home.moviefinder.R;
import com.home.moviefinder.data.model.Movie;
import com.home.moviefinder.data.network.response.MoviesResponse;

import java.util.List;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolder> {

    List<MoviesResponse> movies;

    public ListMovieAdapter(List<MoviesResponse> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ListMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ListMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieViewHolder holder, int position) {
        holder.textTitleMovie.setText(movies.get(position).getOriginalTitle());
    }

    @Override
    public int getItemCount() {
        return (movies != null && movies.size() > 0) ? movies.size() : 0;
    }

    static class ListMovieViewHolder extends RecyclerView.ViewHolder{
        private TextView textTitleMovie;

        public ListMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitleMovie = itemView.findViewById(R.id.text_title_movie);
        }
    }
}
