package io.codeforall.bootcamp.paymentStrategy;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void execute(Double value) {
        System.out.println("Total: $" + value);
        System.out.println("Taking the machine...");
        System.out.println("Typing the value...");
        System.out.println("Waiting for payment processing...");
        System.out.println("Generating receipt...");
        System.out.println("Payment finished!");
    }
}
