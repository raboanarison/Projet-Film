package org.HEI.kdot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
public class Subcription {
    private final int id;
    private final Instant beganAt;
    private SubscriptionType subscriptionType;
}
