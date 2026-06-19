package org.HEI.kdot;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Show {
    private final int id;
    private final String showName;
    private final List<Season> seasons;
    private final List<Rating> ratings;
}
