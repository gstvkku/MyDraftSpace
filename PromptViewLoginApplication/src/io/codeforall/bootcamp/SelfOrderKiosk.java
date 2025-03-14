package io.codeforall.bootcamp;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.HashMap;

public class SelfOrderKiosk {

    private Stock kfcStock;
    private Prompt prompt;
    private String offerOfDay;
    private String currentClient;
    private String systemPassword;
    private String lastOrderInformation;

    public SelfOrderKiosk(String systemPassword) {

        this.kfcStock = new Stock();
        this.prompt = new Prompt(System.in, System.out);
        this.offerOfDay = null;
        this.currentClient = null;
        this.lastOrderInformation = null;
        this.systemPassword = systemPassword;
        
    }

    public void work() {

        while (this.currentClient.equals(null)) {

            System.out.println("Welcome to the Kernel Fried Chicken Burguer Place!" + "\n");
            StringInputScanner nameQuestion = new StringInputScanner();
            nameQuestion.setMessage("Please type your name to proceed with the order:");
            this.currentClient = prompt.getUserInput(nameQuestion);

        }

    }

    public void initMenu() {

    }

    public void hamburguersMenu() {

    }

    public void beveragesMenu() {

    }

    public void desertsMenu() {

    }

    public void finishOrder() {

    }

}
