package org.HEI.kdot;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Playlist {
    private final int id;
    private String name;
    private List<Show> shows;
    private List<Movie> movies;

    //methode d'ajout d'un nouveau Movie dans une playlst
    public void addMovie(Movie newMovie){

        this.movies.add(newMovie);
    }

    // methode d'ajout d'un nouveau show dans une playlist
    public void addShow(Show newShow){
        this.shows.add(newShow);
    }
}
