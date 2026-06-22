package org.HEI.kdot.service;

import org.HEI.kdot.*;

import java.util.List;

public class AdminService {
    private final SubscriptionService subscriptionService;
    private final MovieService movieService;
    private final UserService userService;

    public AdminService(SubscriptionService subscriptionService,
                        MovieService movieService,
                        UserService userService) {
        this.subscriptionService = subscriptionService;
        this.movieService = movieService;
        this.userService = userService;
    }

    public double getTotalRevenue() {
        return subscriptionService.getTotalRevenue();
    }

    public List<SubscriptionRecord> getActiveSubscriptions() {
        return subscriptionService.getAllActiveSubscriptions();
    }

    public List<Movie> getTopRatedMovies(int limit) {
        return movieService.getTopRated(limit);
    }

    public List<User> getAllUsers() {
        return userService.findAll();
    }

    public long countActiveSubscribers() {
        return subscriptionService.getAllActiveSubscriptions().stream()
                .map(r -> r.getUser().getId())
                .distinct()
                .count();
    }
}