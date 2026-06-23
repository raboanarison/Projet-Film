package org.HEI.kdot.service;

import org.HEI.kdot.modele.MediaSuggestions;
import org.HEI.kdot.modele.User;

public class RecommendationService {
    private final MovieService movieService;
    private final ShowService showService;

    public RecommendationService(MovieService movieService, ShowService showService) {
        this.movieService = movieService;
        this.showService = showService;
    }

    public MediaSuggestions getSuggestions(User user, int limit) {
        return new MediaSuggestions(
                movieService.getSuggestions(user, limit),
                showService.getSuggestions(user, limit)
        );
    }
}