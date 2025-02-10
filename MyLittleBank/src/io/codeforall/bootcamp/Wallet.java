package io.codeforall.bootcamp;

public class Wallet {
    private double money;

    public Wallet(double firstValue) {
        this.money += firstValue;
        System.out.println("Now you have a wallet!");
    }

    public double getMoney() {
        return this.money;
    }

    public void reduceMoney(double value) {
        if (value < 0) {
            System.out.println("Invalid value!");
        }
        if (value <= this.money) {
            this.money -= value;
            System.out.println("Now you have $" + this.money + " on your wallet!");
        } else if (value == 0.0) {
            System.out.println("Nothing changes in your wallet.");
        } else {
            System.out.println("You don't have enough money to spend this value :(");
        }
    }

    public void addMoney(double value) {
        if (value < 0) {
            System.out.println("Invalid value!");
        } else if (value == 0.0) {
            System.out.println("Nothing changes in your wallet.");
        } else {
            this.money += value;
            System.out.println("Now you have $" + this.money + " on your wallet!");
        }
    }
}
