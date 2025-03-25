package io.codeforall.bootcamp.client;

import io.codeforall.bootcamp.context.Bartender;

public class Client {

    private String name;
    private Order order;
    private Bartender bartender;

    public Client(String name, Bartender bartender) {
        this.name = name;
        this.order = null;
        this.bartender = bartender;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Bartender getBartender() {
        return bartender;
    }

    public Order getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

}
