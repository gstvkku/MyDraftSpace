package io.codeforall.bootcamp;

public class Playground {
    public static void main(String[] args) {
        Person me = new Person("Gustavo");
        me.setWallet(new Wallet(10.0));
        PigBank sharedBank = new PigBank(100, 222);
        me.createNewAccount(sharedBank);
        System.out.println("------------------------------------");
        Person joca = new Person("Jorginho");
        joca.createNewAccount(sharedBank);
        joca.setWallet(new Wallet(10.0));
        System.out.println("------------------------------------");
        joca.openWallet();
        me.putMoneyToBank(5.0, 222);
        me.takeMoneyFromBank(40, 223);
        me.spendMoney(30);
        me.spendMoney(0.0);
        // Each person has its own wallet
        // each person can retrieve money from the bank into the WALLET (new type), and the opposite
        // each person can only spend from their own wallet
        // each person can work for their own money to save it in their wallet
        // no pocket money allowed
    }
}
