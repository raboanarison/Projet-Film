package org.HEI.kdot.modele;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Rating {
    private final int id;
    private final User user;
    private final String comment;
    private RatingNumber ratingNumber;
}
