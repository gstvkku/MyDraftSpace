package io.codeforall.bootcamp;

public class Demon extends Genie {
    public boolean hasBeenSacrificed = false;
    public Demon(int numberOfWishes) {
        super(numberOfWishes);
        System.out.println(name + ", the demon, appeared");
    }

    @Override
    public void grantAWish(String wish) {
        if (!hasBeenSacrificed) {
            System.out.println("Your wish - " + wish + " - has been granted by " + name + ", the demon. But something bad is probably going to happen.");
            return;
        }
        System.out.println("You can't ask " + name + ", the demon, for wishes because it has been sacrificed ");
    }
}
