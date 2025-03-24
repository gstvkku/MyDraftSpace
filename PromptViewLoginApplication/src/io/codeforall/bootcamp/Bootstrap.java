package io.codeforall.bootcamp;

import io.codeforall.bootcamp.model.Order;
import io.codeforall.bootcamp.model.SelfOrderKiosk;
import io.codeforall.bootcamp.model.Stock;
import org.academiadecodigo.bootcamp.Prompt;

import java.util.ArrayList;

public class Bootstrap {

    private SelfOrderKiosk selfOrderKiosk;

    public SelfOrderKiosk getSelfOrderKiosk() {
        return selfOrderKiosk;
    }

    public void initObjects() {

        this.selfOrderKiosk = new SelfOrderKiosk();
        Stock stock = new Stock();
        Prompt prompt = new Prompt(System.in, System.out);
        ArrayList<Order> lastOrders = new ArrayList<>();

        selfOrderKiosk.setKfcStock(stock);
        selfOrderKiosk.setPrompt(prompt);
        selfOrderKiosk.setLastOrders(lastOrders);

    }

}
