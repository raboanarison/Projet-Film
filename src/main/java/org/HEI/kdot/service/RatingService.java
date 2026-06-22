package org.HEI.kdot.service;

import org.HEI.kdot.*;

import java.util.ArrayList;
import java.util.List;

public class RatingService {
    private final List<Rating> ratings = new ArrayList<>();
    private int nextId = 1;

    public Rating rateMovie(User user, Movie movie, RatingNumber number, String comment) {
        Rating rating = Rating.builder()
                .id(nextId++)
                .user(user)
                .ratingNumber(number)
                .comment(comment)
                .build();
        movie.ratings().add(rating);
        ratings.add(rating);
        return rating;
    }

    public Rating rateShow(User user, Show show, RatingNumber number, String comment) {
        Rating rating = Rating.builder()
                .id(nextId++)
                .user(user)
                .ratingNumber(number)
                .comment(comment)
                .build();
        show.getRatings().add(rating);
        ratings.add(rating);
        return rating;
    }
}