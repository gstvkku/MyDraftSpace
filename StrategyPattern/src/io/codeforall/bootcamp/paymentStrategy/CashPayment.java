package io.codeforall.bootcamp.paymentStrategy;

public class CashPayment implements PaymentStrategy{
    @Override
    public void execute(Double value) {
        System.out.println("Total: $" + value);
        System.out.println("Receiving cash...");
        System.out.println("Generating receipt...");
        System.out.println("Payment finished!");
    }
}
