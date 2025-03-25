package io.codeforall.bootcamp.client;

import io.codeforall.bootcamp.paymentStrategy.PaymentStrategy;
import io.codeforall.bootcamp.preparationStrategy.PreparationStrategy;

public class Order {

    private PreparationStrategy preparationStrategy;
    private PaymentStrategy paymentStrategy;

    public Order(PreparationStrategy preparationStrategy, PaymentStrategy paymentStrategy) {
        this.preparationStrategy = preparationStrategy;
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public PreparationStrategy getPreparationStrategy() {
        return preparationStrategy;
    }

}
