package org.HEI.kdot.service;

import org.HEI.kdot.modele.Movie;
import org.HEI.kdot.modele.Playlist;
import org.HEI.kdot.modele.Show;
import org.HEI.kdot.modele.User;

import java.util.ArrayList;

public class PlaylistService {
    private int nextId = 1;

    public Playlist createPlaylist(User user, String name) {
        Playlist playlist = Playlist.builder()
                .id(nextId++)
                .name(name)
                .movies(new ArrayList<>())
                .shows(new ArrayList<>())
                .build();
        user.getPlaylists().add(playlist);
        return playlist;
    }

    public void addMovie(Playlist playlist, Movie movie) {
        playlist.getMovies().add(movie);
    }

    public void addShow(Playlist playlist, Show show) {
        playlist.getShows().add(show);
    }

    public void removeMovie(Playlist playlist, int movieId) {
        playlist.getMovies().removeIf(m -> m.id() == movieId);
    }

    public void removeShow(Playlist playlist, int showId) {
        playlist.getShows().removeIf(s -> s.getId() == showId);
    }
}