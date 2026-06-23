package org.HEI.kdot.modele;

import lombok.Builder;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

// a movie should have view number

@Builder
public record Movie(int id, String title, String description, List<MovieType> typesMovies, List<Director> directors,
                    List<Actor> actors, LocalDate releaseDate, Duration duration, ProductionSociety productionSociety, List<Rating> ratings) {
}