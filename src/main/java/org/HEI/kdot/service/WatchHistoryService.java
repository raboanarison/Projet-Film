package org.HEI.kdot.service;

import org.HEI.kdot.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class WatchHistoryService {
    private final List<WatchHistory> history = new ArrayList<>();
    private int nextId = 1;

    public WatchHistory recordMovie(User user, Movie movie) {
        WatchHistory entry = WatchHistory.builder()
                .id(nextId++)
                .movie(movie)
                .watchedAt(Instant.now())
                .build();
        history.add(entry);
        user.getWatchHistory().add(entry);
        return entry;
    }

    public WatchHistory recordShow(User user, Show show) {
        WatchHistory entry = WatchHistory.builder()
                .id(nextId++)
                .show(show)
                .watchedAt(Instant.now())
                .build();
        history.add(entry);
        user.getWatchHistory().add(entry);
        return entry;
    }

    public List<WatchHistory> getHistoryByUser(User user) {
        return user.getWatchHistory();
    }
}