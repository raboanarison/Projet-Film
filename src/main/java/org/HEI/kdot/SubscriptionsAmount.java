package org.HEI.kdot;

import lombok.Builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Double.sum;

@Builder
public class SubscriptionsAmount {
    private List<Payment> paymentList;

    //methode d'ajout de payment
    public void addPayment(User user,SubscriptionType subscription,SubscriptionDuration duration){
        Double durationValue=duration.getDiscountRate();
        double subValue=subscription.getPricePerMonth();
        double finalAmount=subValue*(1-durationValue);
        Payment payment=new Payment(user,finalAmount);
        this.paymentList.add(payment);
    }

    //methode de suivi du montant total des transactions
    public double montantTotal(){
        double total=0.0;
        for(Payment p:paymentList) {
            total += p.amount();
        }
        return total;
    }
}
