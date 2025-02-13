package io.codeforall.bootcamp;

public class SandBox {
    public static void main(String[] args) {
        Lamp lamp = new Lamp(3);
        Lamp myLittleLamp = new Lamp(3);

        if (lamp.compareLamps(myLittleLamp)){
            System.out.println("Lamps are equal");
        } else System.out.println("Lamps are not equal");

        Genie grumpyGenie = lamp.rub(3);

        if (lamp.compareLamps(myLittleLamp)){
            System.out.println("Lamps are equal");
        } else System.out.println("Lamps are not equal");

        Genie goodGenie = lamp.rub(2);
        grumpyGenie.grantAWish("Infinite money");
        grumpyGenie.grantAWish("Infinite money");

        goodGenie.grantAWish("infinite money");
        goodGenie.grantAWish("infinite money");
        goodGenie.grantAWish("infinite money");

        lamp.rub(3);
        Genie demon = lamp.rub(1);
        demon.grantAWish("1");
        demon.grantAWish("2");
        demon.grantAWish("3");
        lamp.recharge(demon);
        demon.grantAWish("Infinite money");
        lamp.rub(3);
        lamp.rub(3);
        lamp.rub(3);
        lamp.rub(3);
        lamp.rub(3);
    }
}
