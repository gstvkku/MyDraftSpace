package io.codeforall.bootcamp;

public class GrumpyGenie extends Genie {
    private boolean hasMadeAWish = false;
    public GrumpyGenie(int numberOfWishes){
        super(numberOfWishes);
        System.out.println(name + ", the grumpy genie appeared");
    }

    @Override
    public void grantAWish(String wish) {
        if (!hasMadeAWish){
            super.grantAWish(wish);
            hasMadeAWish = true;
            return;
        }
        System.out.println(name + ", the grumpy genie, doesn't want to grant you any more wishes.");
    }
}
