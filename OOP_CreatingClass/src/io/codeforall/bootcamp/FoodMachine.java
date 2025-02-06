package io.codeforall.bootcamp;

public class FoodMachine {
    private String brand = "KUNFT";
    private String version = "FunnyFood 2020";
    public String food;
    public int price;
    public int treasure;
    public int defaultPassWord;

    public FoodMachine(String product, int value, int pass, int money) {
        this.food = product;
        this.price = value;
        this.defaultPassWord = pass;
        this.treasure = money;
    }

    public void toTakeFood(int cash) {
        if (cash == price) {
            this.treasure += price;
            System.out.println("The machine just gave you a/an: " + food);
        } else if (cash > price && cash < treasure) {
            int change = cash - price;
            this.treasure += (cash - change);
            System.out.println("The machine just gave you a/an: " + food);
            System.out.println("Here is your change: $" + change);
        } else if (cash > treasure) {
            System.out.println("Sorry, the machine don`t have change for you. You can`t use it :(");
            System.out.println("Here is your money: $" + cash);
        } else if (cash < price) {
            System.out.println("Sorry, you don`t have enough money to use this machine :(");
        } else if (food == null) {
            System.out.println("Sorry, the machine is empty :(");
        }
    }

    public void toSeeTheMenu() {
        System.out.println("Welcome! :) Here is the day menu: " + food + " | Price: $" + price);
    }
    public void toPutFoodInside(int pass, String product) {
        if (pass == defaultPassWord) {
            this.food = product;
            System.out.println("Your machine's stock has been updated!");
        } else {
            System.out.println("Wrong password.");
            System.out.println("Sorry, you are not able to do this :(");
        }
    }

    public void toDefinePrice(int pass, int value) {
        if (pass == defaultPassWord) {
            this.price = value;
            System.out.println("The price of the food has been updated!");
        } else {
            System.out.println("Wrong password.");
            System.out.println("Sorry, you are not able to do this :(");
        }
    }

    public void toSeeMoreInfos(int pass) {
        if (pass == defaultPassWord) {
            System.out.println("Brand: " + brand + " | Version: " + version + " | Money inside: " + treasure);
        } else {
            System.out.println("Wrong password.");
            System.out.println("Sorry, you are not able to do this :(");
        }
    }

    public void toTakeTheMoney(int pass) {
        if (pass == defaultPassWord) {
            System.out.println("Here is your money: $" + treasure);
            this.treasure = 0;
            System.out.println("Machine`s treasure is empty.");
        } else {
            System.out.println("Wrong password.");
            System.out.println("Sorry, you are not able to do this :(");
        }
    }

    public void toPutMoneyInside(int pass, int value) {
        if (pass == defaultPassWord) {
            this.treasure += value;
            System.out.println("Operation completed successfully!");
            System.out.println("The machine`s treasure now is: $" + treasure);
        }
        else {
            System.out.println("Wrong password.");
            System.out.println("Sorry, you are not able to do this :(");
            System.out.println("Here is your money: $" + value);
        }
    }
}
