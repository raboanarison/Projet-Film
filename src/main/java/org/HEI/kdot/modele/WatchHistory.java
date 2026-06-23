package org.HEI.kdot.modele;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class WatchHistory {
    private final int id;
    private Movie movie;
    private Show show;
    private final Instant watchedAt;
}