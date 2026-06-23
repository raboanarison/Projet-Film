package org.HEI.kdot.service;

import org.HEI.kdot.modele.Movie;
import org.HEI.kdot.modele.MovieType;
import org.HEI.kdot.modele.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {
    private final List<Movie> movies = new ArrayList<>();

    public Movie addMovie(Movie movie) {
        movies.add(movie);
        return movie;
    }

    public Movie findById(int id) {
        return movies.stream()
                .filter(m -> m.id() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Movie not found: " + id));
    }

    public List<Movie> findAll() {
        return List.copyOf(movies);
    }

    public List<Movie> findByType(MovieType type) {
        return movies.stream()
                .filter(m -> m.typesMovies().contains(type))
                .toList();
    }

    public List<Movie> findByTitle(String keyword) {
        return movies.stream()
                .filter(m -> m.title().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    public List<Movie> findByActor(int actorId) {
        return movies.stream()
                .filter(m -> m.actors().stream().anyMatch(a -> a.getId() == actorId))
                .toList();
    }

    public List<Movie> findByDirector(int directorId) {
        return movies.stream()
                .filter(m -> m.directors().stream().anyMatch(d -> d.getId() == directorId))
                .toList();
    }

    public List<Movie> getTopRated(int limit) {
        return movies.stream()
                .sorted(Comparator.comparingDouble(this::getAverageRating).reversed())
                .limit(limit)
                .toList();
    }

    public double getAverageRating(Movie movie) {
        if (movie.ratings() == null || movie.ratings().isEmpty())
        {
            return 0;
        }
        return movie.ratings().stream()
                .mapToDouble(r -> r.getRatingNumber().getValue())
                .average()
                .orElse(0);
    }

    public List<Movie> getSuggestions(User user, int limit) {
        List<MovieType> preferredTypes = user.getWatchHistory().stream()
                .filter(h -> h.getMovie() != null)
                .flatMap(h -> h.getMovie().typesMovies().stream())
                .distinct()
                .toList();

        if (preferredTypes.isEmpty()) {
            return getTopRated(limit);
        }
        return movies.stream()
                .filter(m -> user.getWatchHistory().stream()
                        .filter(h -> h.getMovie() != null)
                        .noneMatch(h -> h.getMovie().id() == m.id()))
                .filter(m -> m.typesMovies().stream().anyMatch(preferredTypes::contains))
                .sorted(Comparator.comparingDouble(this::getAverageRating).reversed())
                .limit(limit)
                .toList();
    }
}