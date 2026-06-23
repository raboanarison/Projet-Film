package org.HEI.kdot.modele;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

// Should add payement method in the attributes, new classes too for that, maybe records who should have attributes

@Data
@Builder
public class SubscriptionRecord {
    private final int id;
    private final User user;
    private final Subscription subscription;
    private final Instant subscribedAt;
    private Instant cancelledAt;
}