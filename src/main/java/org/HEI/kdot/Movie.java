package org.HEI.kdot;

import lombok.Builder;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
public record Movie(int id, String title, String description, List<MovieType> typesMovies, List<Director> directors,
                    List<Actor> actors, LocalDate releaseDate, Duration duration, ProductionSociety productionSociety, List<Rating> ratings) {

    // methode rating
    public Movie addRating(Rating newRating){
        List<Rating>newlist=new ArrayList<>(this.ratings);
        newlist.add(newRating);
        return new Movie(this.id,this.title,this.description,this.typesMovies,this.directors,this.actors,this.releaseDate,this.duration,
        this.productionSociety,newlist);
    }
}

