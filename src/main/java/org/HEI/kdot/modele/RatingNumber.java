package org.HEI.kdot.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RatingNumber {
    ONE(1.0),
    ONE_HALF(1.5),
    TWO(2.0),
    TWO_HALF(2.5),
    THREE(3.0),
    THREE_HALF(3.5),
    FOUR(4.0),
    FOUR_HALF(4.5),
    FIVE(5.0);

    private final double value;
}

