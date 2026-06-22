package org.HEI.kdot;

import lombok.Builder;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public record Movie(int id, String title, String description, List<MovieType> typesMovies, List<Director> directors,
                    List<Actor> actors, LocalDate releaseDate, Duration duration, ProductionSociety productionSociety, List<Rating> ratings) {
}