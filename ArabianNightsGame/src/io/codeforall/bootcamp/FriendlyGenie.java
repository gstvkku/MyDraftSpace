package io.codeforall.bootcamp;

public class GoodGenie extends Genie {
    public GoodGenie(int numberOfWishes){
        super(numberOfWishes);
        System.out.println(getName() + ", the good genie, appeared");
    }
}
