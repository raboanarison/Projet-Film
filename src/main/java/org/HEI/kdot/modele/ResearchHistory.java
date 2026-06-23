package org.HEI.kdot.modele;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.Map;

@Data
@AllArgsConstructor
public class ResearchHistory {
    private final int id;
    private Map<Instant, String> researchHistory;
}
