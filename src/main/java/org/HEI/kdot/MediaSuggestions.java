package org.HEI.kdot;

import java.util.List;

public record MediaSuggestions(
        List<Movie> movies,
        List<Show> shows
) {

}