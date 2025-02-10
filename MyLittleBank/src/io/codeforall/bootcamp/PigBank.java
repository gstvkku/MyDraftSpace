package io.codeforall.bootcamp;

public class PigBank {
    private static final String BANKNAME = "PigBank";
    private int ACCOUNTNUMBER;
    private int PASSWORD;
    private double valueInAccount;

    public PigBank(double firstValue, int password) {
       validationToCreateAccount(firstValue, password);
    }

    public void validationToCreateAccount(double firstValue, int password) {
        if (firstValue <= 0 || password <= 0) {
            System.out.println("It was not possible to create your account :( Try again with valid answers!");
        } else {
            this.valueInAccount = firstValue;
            this.PASSWORD = password;
            this.ACCOUNTNUMBER = (int) Math.floor(Math.random() * 3927376) + 189654 + password;
            System.out.println("Now you have a new PigBank account!");
            showInformation();
        }
    }

    public void showInformation() {
        System.out.println("Here is your banking information:");
        System.out.println("Bank: " + this.BANKNAME + " || Account number: " + this.ACCOUNTNUMBER);
        System.out.println("Available value: $" + this.valueInAccount);
    }

    public double verifyToTakeMoney(double value, int password) {
        if (password != this.PASSWORD) {
            System.out.println("Wrong password :( Try again!");
            return 0.0;
        }
        if (value <= 0) {
            System.out.println("You need to put a valid value!!");
            return 0.0;
        } else if (value > this.valueInAccount) {
            System.out.println("You don't have enough money to take this value :(");
            return 0.0;
        } else {
            this.valueInAccount -= value;
            System.out.println("Procedure carried out successfully :)");
            System.out.println("Update | Available value: $" + this.valueInAccount);
            return value;
        }
    }

    public double verifyToPutMoney(double value, int password) {
        if (password != this.PASSWORD) {
            System.out.println("Wrong password! Try again :(");
            return 0.0;
        }
        if (value <= 0) {
            System.out.println("You need to put a valid value!!");
            return 0.0;
        } else {
            this.valueInAccount += value;
            System.out.println("Procedure carried out successfully :)");
            System.out.println("Update | Available value: $" + this.valueInAccount);
            return value;
        }
    }
}
