package io.codeforall.bootcamp;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.ArrayList;

public class SelfOrderKiosk {

    private Stock kfcStock;
    private Prompt prompt;
    private String currentClient;
    private String systemPassword;
    private ArrayList<Order> lastOrders;

    public SelfOrderKiosk(String systemPassword) {

        this.kfcStock = new Stock();
        this.prompt = new Prompt(System.in, System.out);
        this.currentClient = null;
        this.lastOrders = new ArrayList<>();
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
                System.out.println("It's a pleasure to have you here, " + this.currentClient +
                        "! Let's proceed with your order.");
                initMenu();
            }

        }

    }

    public void settingsMenu() {

        if (!passwordVerification()) {
            return;
        }

        System.out.println("Welcome! You are using the settings menu of the system.");
        String[] options = {"See last orders", "Add new Hamburguer", "Add new Beverage",
                "Add new Desert", "Change Password", "Finish Operation"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Select an option:");

        Boolean wantFinish = false;

        while (!wantFinish) {

            int answerIndex = prompt.getUserInput(scanner);

            switch (answerIndex) {

                case 1:
                    seeLastOrders();
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
                    changePassword();
                    break;

                case 6:
                    this.currentClient = null;
                    wantFinish = true;
                    System.out.println("Operation finished." + "\n");

            }

        }

    }

    public void initMenu() {

        String[] options = {"Select Hamburguer", "Select Beverage", "Select Desert", "Cancel Order", "Finish Order"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Select an option:");

        Order currentOrder = new Order(this.currentClient);
        Boolean wantFinish = false;

        while (!wantFinish) {

            int answerIndex = prompt.getUserInput(scanner);

            switch (answerIndex) {

                case 1:
                    showBurguersMenu(currentOrder);
                    break;

                case 2:
                    showBeveragesMenu(currentOrder);
                    break;

                case 3:
                    showDesertsMenu(currentOrder);
                    break;

                case 4:
                    wantFinish = cancelOrder(currentOrder);
                    break;

                case 5:
                    wantFinish = finishOrder(currentOrder, wantFinish);

            }

        }

    }

    public boolean passwordVerification() {

        PasswordInputScanner passwordInputScanner = new PasswordInputScanner();
        passwordInputScanner.setMessage("Please type the system password: ");
        String password = prompt.getUserInput(passwordInputScanner);

        if (password.equals(this.systemPassword)) {
            return true;
        }

        System.out.println("Wrong password! You don't have permission to access the settings menu." + "\n");
        this.currentClient = null;
        return false;

    }

    public void changePassword() {

        PasswordInputScanner passwordInputScanner = new PasswordInputScanner();
        passwordInputScanner.setMessage("Please type the new system password: ");
        this.systemPassword = prompt.getUserInput(passwordInputScanner);

    }

    public void seeLastOrders() {

        if (this.lastOrders.size() == 0) {
            System.out.println("This kiosk has not served any costumers yet.");
            return;
        }

        IntegerRangeInputScanner integerInputScanner = new IntegerRangeInputScanner(1, this.lastOrders.size());
        integerInputScanner.setMessage("This kiosk has " + this.lastOrders.size() +
                " registered orders. Enter the number of one of these orders: ");
        Integer orderNumber = prompt.getUserInput(integerInputScanner);

        Integer orderIndex = orderNumber - 1;
        System.out.println("Client name: " + lastOrders.get(orderIndex).getClientName() + "\n");
        orderResume(lastOrders.get(orderIndex));

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

    public void showBurguersMenu(Order order) {

        String[] options = this.kfcStock.getHamburguers();
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Select your burguer:");
        int answerIndex = prompt.getUserInput(scanner);

        System.out.println("Selected burguer: " + options[answerIndex - 1]);
        order.setSelectedBurguer(options[answerIndex - 1]);

    }

    public void showBeveragesMenu(Order order) {

        String[] options = this.kfcStock.getBeverages();
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Select your beverage:");
        int answerIndex = prompt.getUserInput(scanner);

        System.out.println("Selected beverage: " + options[answerIndex - 1]);
        order.setSelectedBeverage(options[answerIndex - 1]);

    }

    public void showDesertsMenu(Order order) {

        String[] options = this.kfcStock.getDeserts();
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Select your desert:");
        int answerIndex = prompt.getUserInput(scanner);

        System.out.println("Selected desert: " + options[answerIndex - 1]);
        order.setSelectedDesert(options[answerIndex - 1]);

    }

    public boolean finishOrder(Order order, Boolean wantFinish) {

        String[] options = {"Finish Order", "Return to Main Menu"};
        MenuInputScanner scanner = new MenuInputScanner(options);

        orderResume(order);

        if (order.getFinalPrice() == 0) {
            System.out.println("You need to add something to finish your order.");
            return false;
        }

        scanner.setMessage("Select an option:");
        int answerIndex = prompt.getUserInput(scanner);

        if (answerIndex == 1) {
            this.lastOrders.add(order);
            System.out.println("Order number: " + this.lastOrders.size());
            System.out.println("Thank you " + this.currentClient + "! Your order is being prepared :) " +
                    "Please go to the counter to make payment." + "\n");
            this.currentClient = null;
            return true;
        }

        return false;

    }

    public void orderResume(Order order) {

        Double hamburguerValue = 0.0;
        Double beverageValue = 0.0;
        Double desertValue = 0.0;

        System.out.println("--------------------------------------------" + "\n");

        if (order.getSelectedBurguer() != null) {
            System.out.println("- " + order.getSelectedBurguer());
            hamburguerValue = Double.parseDouble(order.getSelectedBurguer().replaceAll("[^\\d.]", ""));
        }

        if (order.getSelectedBeverage() != null) {
            System.out.println("- " + order.getSelectedBeverage());
            beverageValue = Double.parseDouble(order.getSelectedBeverage().replaceAll("[^\\d.]", ""));
        }

        if (order.getSelectedDesert() != null) {
            System.out.println("- " + order.getSelectedDesert() + "\n");
            desertValue = Double.parseDouble(order.getSelectedDesert().replaceAll("[^\\d.]", ""));
        }

        Double total = hamburguerValue + beverageValue + desertValue;
        order.setFinalPrice(total);

        if (total > 0) {
            System.out.println("Total: $" + total);
        }

    }

    public Boolean cancelOrder(Order order) {

        order = null;
        this.currentClient = null;
        System.out.println("Order canceled." + "\n");
        return true;

    }

}
