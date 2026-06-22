package org.HEI.kdot.service;

import org.HEI.kdot.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShowService {
    private final List<Show> shows = new ArrayList<>();

    public Show addShow(Show show) {
        shows.add(show);
        return show;
    }

    public List<Show> getSuggestions(User user, int limit) {
        List<MovieType> preferredTypes = user.getWatchHistory().stream()
                .filter(h -> h.getShow() != null)
                .flatMap(h -> h.getShow().getMovieTypes().stream())
                .distinct()
                .toList();

        if (preferredTypes.isEmpty()) return getTopRated(limit);

        return shows.stream()
                .filter(s -> user.getWatchHistory().stream()
                        .filter(h -> h.getShow() != null)
                        .noneMatch(h -> h.getShow().getId() == s.getId()))
                .filter(s -> s.getMovieTypes().stream().anyMatch(preferredTypes::contains))
                .sorted(Comparator.comparingDouble(this::getAverageRating).reversed())
                .limit(limit)
                .toList();
    }

    public List<Show> getTopRated(int limit) {
        return shows.stream()
                .sorted(Comparator.comparingDouble(this::getAverageRating).reversed())
                .limit(limit)
                .toList();
    }

    public double getAverageRating(Show show) {
        if (show.getRatings() == null || show.getRatings().isEmpty()) return 0;
        return show.getRatings().stream()
                .mapToDouble(r -> r.getRatingNumber().getValue())
                .average()
                .orElse(0);
    }
}