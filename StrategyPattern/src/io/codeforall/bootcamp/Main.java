package io.codeforall.bootcamp;

import io.codeforall.bootcamp.context.Bartender;
import io.codeforall.bootcamp.client.Client;
import io.codeforall.bootcamp.client.Order;
import io.codeforall.bootcamp.paymentStrategy.CreditCardPayment;
import io.codeforall.bootcamp.preparationStrategy.DryMartiniStrategy;

public class Main {
    public static void main(String[] args) {

        Client client = new Client("Wafelda", new Bartender());
        client.setOrder(new Order(new DryMartiniStrategy(), new CreditCardPayment()));
        client.getBartender().receiveOrder(client, client.getOrder());



    }
}