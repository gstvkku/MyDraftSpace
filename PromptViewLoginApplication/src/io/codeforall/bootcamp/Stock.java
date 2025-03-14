package io.codeforall.bootcamp;

import java.util.HashMap;

public class Stock {

    private HashMap hamburguers;
    private HashMap beverages;
    private HashMap deserts;

    public Stock() {

        this.hamburguers = new HashMap<>();
        this.beverages = new HashMap();
        this.deserts = new HashMap();

        initStock();

    }

    public void initStock() {

        hamburguers.put("Cluck Norris", 5);
        hamburguers.put("The Chickenator", 6);
        hamburguers.put("Fowl Play", 6);
        hamburguers.put("Cluck'n'Roll", 8);
        hamburguers.put("The Chick Magnet", 10);

        beverages.put("Watter Bottle", 1);
        beverages.put("Coke", 2);
        beverages.put("Diet Coke", 2);
        beverages.put("Seven Up", 2);
        beverages.put("Monster Energy", 3);

        deserts.put("Chocolate cookie", 4);
        deserts.put("Vanilla Ice Cream", 3);
        deserts.put("Mini Apple Pie", 5);

    }

    public void setNewHamburguer(String hamburguer, Double value) {

        this.hamburguers.put(hamburguer, value);

    }

    public void setNewBeverage(String beverage, Double value) {

        this.beverages.put(beverage, value);

    }

    public void setNewDesert(String desert, Double value) {

        this.deserts.put(desert, value);

    }

    public HashMap getHamburguers() {
        return hamburguers;
    }

    public HashMap getBeverages() {
        return beverages;
    }

    public HashMap getDeserts() {
        return deserts;
    }
}
