package org.HEI.kdot.modele;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
public class Subscription {
    private final int id;
    private final Instant beganAt;
    private SubscriptionType subscriptionType;
    private SubscriptionDuration subscriptionDuration;
}