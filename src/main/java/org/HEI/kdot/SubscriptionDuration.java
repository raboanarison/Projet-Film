package org.HEI.kdot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubscriptionDuration {
    MONTHLY(1, 0.0),
    QUARTERLY(3, 0.10),
    YEARLY(12, 0.25);

    private final int months;
    private final double discountRate;

    public double calculateTotalPrice(double pricePerMonth) {
        double basePrice = pricePerMonth * this.months;
        double discountAmount = basePrice * this.discountRate;
        return basePrice - discountAmount;
    }
}

