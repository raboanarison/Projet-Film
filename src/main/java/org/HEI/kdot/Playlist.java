package org.HEI.kdot;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Playlist {
    private final int id;
    private String name;
    private List<Show> shows;
    private List<Movie> movies;
}
