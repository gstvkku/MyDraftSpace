package io.codeforall.bootcamp.context;

import io.codeforall.bootcamp.client.Client;
import io.codeforall.bootcamp.client.Order;

public class Bartender {

    private Client currentClient;
    private Double defaultValue = 7.50;

    public void receiveOrder(Client client, Order order) {

        this.currentClient = client;
        System.out.println("Welcome, " + client.getName() + "! Let's start preparing your drink." + "\n");

        prepareDrink();
        receivePayment();

        System.out.println("Thank you for the preference, " + client.getName() + ". Enjoy it!");
        this.currentClient.setOrder(null);
        this.currentClient = null;

    }

    public void prepareDrink() {

        this.currentClient.getOrder().getPreparationStrategy().execute();
        System.out.println("Your drink is ready, " + currentClient.getName() +
                "! Let's proceed with the payment." + "\n");

    }
    public void receivePayment() {

        this.currentClient.getOrder().getPaymentStrategy().execute(defaultValue);
        System.out.println("\n");

    }

}
