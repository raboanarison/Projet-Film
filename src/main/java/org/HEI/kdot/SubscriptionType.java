package org.HEI.kdot;
import lombok.Getter;

@Getter
public enum SubscriptionType {

    STANDARD(1, 4.99),
    PREMIUM(6, 14.99),
    FAMILY(10, 24.99);

    private final int maxUsers;
    private final double pricePerMonth;

    SubscriptionType(int maxUsers, double pricePerMonth) {
        this.maxUsers = maxUsers;
        this.pricePerMonth = pricePerMonth;
    }
}

