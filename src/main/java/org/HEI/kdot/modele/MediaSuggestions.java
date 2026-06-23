package org.HEI.kdot.modele;

import java.util.List;

public record MediaSuggestions(
        List<Movie> movies,
        List<Show> shows
) {

}