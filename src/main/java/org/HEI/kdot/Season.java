package org.HEI.kdot;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Season {
    private Show show;
    private List<Movie> episodes;
}
