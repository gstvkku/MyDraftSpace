package io.codeforall.bootcamp;

public class FriendlyGenie extends Genie {
    public FriendlyGenie(int numberOfWishes) {
        super(numberOfWishes);
        System.out.println(getName() + ", the good genie, appeared.");
    }
}
