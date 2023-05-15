package com.home.moviefinder.ui.listMovie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.home.moviefinder.R;
import com.home.moviefinder.data.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolder> {

    private List<Movie> movies;
    private static ItemMovieClickListener itemMovieClickListener;


    public ListMovieAdapter(ItemMovieClickListener itemMovieClickListener){
        this.itemMovieClickListener = itemMovieClickListener;
        movies = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ListMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieViewHolder holder, int position) {
        holder.bind(movies.get(position));

    }

    @Override
    public int getItemCount() {
        return (movies != null && movies.size() > 0) ? movies.size() : 0;
    }

    static class ListMovieViewHolder extends RecyclerView.ViewHolder{
        private TextView textTitleMovie;
        private ImageView imagePosterMovie;
        private Movie movie;


        public ListMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitleMovie = itemView.findViewById(R.id.text_title_movie);
            imagePosterMovie = itemView.findViewById(R.id.image_poster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(itemMovieClickListener != null){
                        itemMovieClickListener.onItemMovieClicado(movie);
                    }
                }
            });
        }

        public void bind(Movie movie){
            this.movie = movie;
            textTitleMovie.setText(movie.getTitle());
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w342/"+movie.getPosterImage())
                    .into(imagePosterMovie);
        }
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public interface ItemMovieClickListener{
        void onItemMovieClicado(Movie movie);
    }
}
