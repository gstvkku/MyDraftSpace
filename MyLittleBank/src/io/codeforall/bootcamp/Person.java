package io.codeforall.bootcamp;

public class Person {
    private String name;
    private PigBank personalAccount;
    private Wallet personalWallet;

    public Person(String name) {
        this.name = name;
        System.out.println("Welcome, " + this.name + "!");

    }

    public void setWallet(Wallet myWallet) {
        this.personalWallet = myWallet;
    }

    public void createNewAccount(PigBank account) {
        this.personalAccount = account;
    }

    public void takeMoneyFromBank(double value, int password) {
        personalWallet.addMoney(personalAccount.verifyToTakeMoney(value, password));
    }

    public void putMoneyToBank(double value, int password) {
        if (value <= personalWallet.getMoney()) {
            personalWallet.reduceMoney(personalAccount.verifyToPutMoney(value, password));
        }
        else {
            System.out.println("You don't have enough money to put this value in your account :(");
        }
    }

    public void spendMoney(double value) {
        personalWallet.reduceMoney(value);
    }

    public void receiveMoney(double value) {
        personalWallet.addMoney(value);
    }

    public void seeAccountInformation(int password) {
        personalAccount.showInformation();
    }
    public void openWallet() {
        System.out.println("You have $" + personalWallet.getMoney() + " on your wallet!");
    }

    public void work() {
        receiveMoney(50.0);
    }
}
