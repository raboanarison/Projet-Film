package org.HEI.kdot;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class SubscriptionRecord {
    private final int id;
    private final User user;
    private final Subscription subscription;
    private final Instant subscribedAt;
    private Instant cancelledAt;
}