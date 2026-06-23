package org.HEI.kdot.service;

import org.HEI.kdot.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionService {
    private final List<SubscriptionRecord> records = new ArrayList<>();
    private int nextId = 1;

    public SubscriptionRecord subscribe(User user, SubscriptionType type, SubscriptionDuration duration) {
        getActiveRecord(user).ifPresent(this::cancel);

        Subscription subscription = Subscription.builder()
                .id(nextId++)
                .beganAt(Instant.now())
                .subscriptionType(type)
                .subscriptionDuration(duration)
                .build();

        SubscriptionRecord record = SubscriptionRecord.builder()
                .id(nextId++)
                .user(user)
                .subscription(subscription)
                .subscribedAt(Instant.now())
                .build();

        records.add(record);
        user.getSubscriptionHistory().add(record);
        return record;
    }

    public void cancel(SubscriptionRecord record) {
        record.setCancelledAt(Instant.now());
    }

    public java.util.Optional<SubscriptionRecord> getActiveRecord(User user) {
        return records.stream()
                .filter(r -> r.getUser().getId() == user.getId())
                .filter(r -> r.getCancelledAt() == null)
                .findFirst();
    }

    public List<SubscriptionRecord> getHistoryByUser(User user) {
        return records.stream()
                .filter(r -> r.getUser().getId() == user.getId())
                .toList();
    }

    public List<SubscriptionRecord> getAllActiveSubscriptions() {
        return records.stream()
                .filter(r -> r.getCancelledAt() == null)
                .toList();
    }

    //should  use the Subscription duration, the discount is not used here !!!!
    public double getTotalRevenue() {
        return records.stream()
                .mapToDouble(r -> r.getSubscription().getSubscriptionDuration()
                        .calculateTotalPrice(r.getSubscription().getSubscriptionType().getPricePerMonth()))
                .sum();
    }
}