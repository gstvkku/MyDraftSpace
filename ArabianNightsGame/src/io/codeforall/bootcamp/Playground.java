package io.codeforall.bootcamp;

public class Playground {
    public static void main(String[] args) {
        Lamp lamp = new Lamp(0);
        Lamp myLittleLamp = new Lamp(3);
        Genie genie1 = lamp.rub(2);
        genie1.grantAWish("Fast car");
        lamp.recharge(genie1);
    }
}
