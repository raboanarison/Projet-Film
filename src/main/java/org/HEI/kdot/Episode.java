package org.HEI.kdot;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.util.List;

// We should create an abstract class mother for episode and movie cause they pretty much have same attributes

@Data
@Builder
public class Episode {
    private final int id;
    private final int episodeNumber;
    private String title;
    private String description;
    private Duration duration;
    private List<Director> directors;
    private List<Actor> actors;
}