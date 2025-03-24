package io.codeforall.bootcamp.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Stock {

    private HashMap hamburguers;
    private HashMap beverages;
    private HashMap deserts;

    public Stock() {

        this.hamburguers = new HashMap();
        this.beverages = new HashMap();
        this.deserts = new HashMap();

        initStock();

    }

    public void initStock() {

        hamburguers.put("Cluck Norris", 5.0);
        hamburguers.put("The Chickenator", 6.0);
        hamburguers.put("Fowl Play", 6.0);
        hamburguers.put("Cluck'n'Roll", 8.0);
        hamburguers.put("The Chick Magnet", 10.0);

        beverages.put("Watter Bottle", 1.0);
        beverages.put("Coke", 2.0);
        beverages.put("Diet Coke", 2.0);
        beverages.put("Seven Up", 2.0);
        beverages.put("Monster Energy", 3.0);

        deserts.put("Chocolate cookie", 4.0);
        deserts.put("Vanilla Ice Cream", 3.0);
        deserts.put("Mini Apple Pie", 5.0);

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

    public String[] getHamburguers() {

        String[] options = new String[hamburguers.size()];
        ArrayList<String> burguers = new ArrayList<>(hamburguers.keySet());

        for (int i = 0; i < hamburguers.size(); i++) {

            options[i] = burguers.get(i) + " $" + hamburguers.get(burguers.get(i)).toString();

        }

        return options;

    }

    public String[] getBeverages() {

        String[] options = new String[beverages.size()];
        ArrayList<String> beves = new ArrayList<>(beverages.keySet());

        for (int i = 0; i < beverages.size(); i++) {

            options[i] = beves.get(i) + " $" + beverages.get(beves.get(i)).toString();

        }

        return options;

    }

    public String[] getDeserts() {

        String[] options = new String[deserts.size()];
        ArrayList<String> deser = new ArrayList<>(deserts.keySet());

        for (int i = 0; i < deserts.size(); i++) {

            options[i] = deser.get(i) + " $" + deserts.get(deser.get(i)).toString();

        }

        return options;

    }
}
