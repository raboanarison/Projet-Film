package org.HEI.kdot.modele;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Show {
    private final int id;
    private final String showName;
    private String description;
    private List<MovieType> movieTypes;
    private final List<Season> seasons;
    private final List<Rating> ratings;
}