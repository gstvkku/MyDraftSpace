package io.codeforall.bootcamp;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.ArrayList;
import java.util.HashMap;

public class SelfOrderKiosk {

    private Stock kfcStock;
    private Prompt prompt;
    private String currentClient;
    private String systemPassword;
    private Order lastOrder;

    public SelfOrderKiosk(String systemPassword) {

        this.kfcStock = new Stock();
        this.prompt = new Prompt(System.in, System.out);
        this.currentClient = null;
        this.lastOrder = null;
        this.systemPassword = systemPassword;

    }

    public void work() {

        while (this.currentClient == null) {

            System.out.println("Welcome to the Kernel Fried Chicken Burguer Place!" + "\n");

            StringInputScanner nameQuestion = new StringInputScanner();
            nameQuestion.setMessage("Please type your name to proceed with the order: ");
            this.currentClient = prompt.getUserInput(nameQuestion);

            if (this.currentClient.equals("Settings Menu")) {
                settingsMenu();
            } else {
                System.out.println("It's a pleasure to have you here, " + this.currentClient + "! Let's proceed with your order.");
                initMenu();
            }

        }

    }

    public boolean passwordVerification() {

        StringInputScanner newItemName = new StringInputScanner();
        newItemName.setMessage("Please type the system password: ");
        String password = prompt.getUserInput(newItemName);

        if (password.equals(this.systemPassword)) {
            return true;
        }

        System.out.println("Wrong password! You don't have permission to access the settings menu." + "\n");
        this.currentClient = null;
        return false;

    }


    public void settingsMenu() {

        if (!passwordVerification()) {
            return;
        }

        System.out.println("Welcome! You are using the settings menu of the system.");
        String[] options = {"See last order", "Add new Hamburguer", "Add new Beverage", "Add new Desert", "Finish Operation" };
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Select an option:");

        Boolean wantFinish = false;

        while (!wantFinish) {

            int answerIndex = prompt.getUserInput(scanner);

            switch (answerIndex) {

                case 1:
                    System.out.println("Client name: " + lastOrder.getClientName() + "\n");
                    orderResume(lastOrder);
                    break;

                case 2:
                    addNewItem("Hamburguer");
                    break;

                case 3:
                    addNewItem("Beverage");
                    break;

                case 4:
                    addNewItem("Desert");
                    break;

                case 5:
                    this.currentClient = null;
                    wantFinish = true;
                    System.out.println("Operation finished.");

            }

        }

    }

    public void addNewItem(String typeOfItem) {

        StringInputScanner newItemName = new StringInputScanner();
        newItemName.setMessage("Name of the new item: ");
        String name = prompt.getUserInput(newItemName);

        DoubleInputScanner newItemValue = new DoubleInputScanner();
        newItemValue.setMessage("Value of the new item: ");
        Double value = prompt.getUserInput(newItemValue);

        switch (typeOfItem) {

            case "Hamburguer":
                this.kfcStock.setNewHamburguer(name, value);
                break;

            case "Beverage":
                this.kfcStock.setNewBeverage(name, value);
                break;

            case "Desert":
                this.kfcStock.setNewDesert(name, value);

        }

    }

    public void initMenu() {

        String[] options = {"Select Hamburguer", "Select Beverage", "Select Desert", "Cancel Order", "Finish Order" };
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Select an option:");

        Order currentOrder = new Order(this.currentClient);
        Boolean wantFinish = false;

        while (!wantFinish) {

            int answerIndex = prompt.getUserInput(scanner);

            switch (answerIndex) {

                case 1:
                    hamburguersMenu(currentOrder);
                    break;

                case 2:
                    beveragesMenu(currentOrder);
                    break;

                case 3:
                    desertsMenu(currentOrder);
                    break;

                case 4:
                    wantFinish = cancelOrder(currentOrder);
                    break;

                case 5:
                    wantFinish = finishOrder(currentOrder, wantFinish);

            }

        }

    }

    public void hamburguersMenu(Order order) {

        String[] options = this.kfcStock.getHamburguers();
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Select your burguer:");
        int answerIndex = prompt.getUserInput(scanner);

        System.out.println("Selected burguer: " + options[answerIndex - 1]);
        order.setSelectedBurguer(options[answerIndex - 1]);

    }

    public void beveragesMenu(Order order) {

        String[] options = this.kfcStock.getBeverages();
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Select your beverage:");
        int answerIndex = prompt.getUserInput(scanner);

        System.out.println("Selected beverage: " + options[answerIndex - 1]);
        order.setSelectedBeverage(options[answerIndex - 1]);

    }

    public void desertsMenu(Order order) {

        String[] options = this.kfcStock.getDeserts();
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Select your desert:");
        int answerIndex = prompt.getUserInput(scanner);

        System.out.println("Selected desert: " + options[answerIndex - 1]);
        order.setSelectedDesert(options[answerIndex - 1]);

    }

    public boolean finishOrder(Order order, Boolean wantFinish) {

        String[] options = {"Finish Order", "Return to Main Menu" };
        MenuInputScanner scanner = new MenuInputScanner(options);

        System.out.println("Order Resume:" + "\n");
        orderResume(order);
        scanner.setMessage("Select an option:");
        int answerIndex = prompt.getUserInput(scanner);

        if (answerIndex == 1) {
            System.out.println("Thank you " + this.currentClient + "! Your order is being prepared :) " +
                    "Please go to the counter to make payment." + "\n");
            this.lastOrder = order;
            this.currentClient = null;
            return true;
        }

        return false;

    }

    public void orderResume(Order order) {

        Double hamburguerValue = 0.0;
        Double beverageValue = 0.0;
        Double desertValue = 0.0;

        if (order.getSelectedBurguer() != null) {
            System.out.println("- " + order.getSelectedBurguer());
            hamburguerValue = Double.parseDouble(order.getSelectedBurguer().replaceAll("\\D", ""));
        }

        if (order.getSelectedBeverage() != null) {
            System.out.println("- " + order.getSelectedBeverage());
            beverageValue = Double.parseDouble(order.getSelectedBeverage().replaceAll("\\D", ""));
        }

        if (order.getSelectedDesert() != null) {
            System.out.println("- " + order.getSelectedDesert() + "\n");
            desertValue = Double.parseDouble(order.getSelectedDesert().replaceAll("\\D", ""));
        }

        Double total = hamburguerValue + beverageValue + desertValue;
        order.setFinalPrice(total);

        System.out.println("Total: $" + total);

    }

    public Boolean cancelOrder(Order order) {

        order = null;
        this.currentClient = null;
        System.out.println("Order canceled." + "\n");
        return true;

    }

}
