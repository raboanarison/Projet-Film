package org.HEI.kdot.modele;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Season {
    private final int id;
    private final int seasonNumber;
    private Show show;
    private List<Episode> episodes;
}