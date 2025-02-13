package io.codeforall.bootcamp;

public class Lamp {
    private int maxNumberOfCharges; // 5
    private int numberOfRecharges; // vezes que foi recarregado
    private int chargesLeft; // 5, rub, 4 rub

    private int numberOfRubs = 0;
    public Lamp(int maxNumberOfCharges){
        this.maxNumberOfCharges = maxNumberOfCharges;
        this.chargesLeft = maxNumberOfCharges;
        System.out.println("You found a magic lamp, you can rub it " + maxNumberOfCharges + " times.");

    }

    public int getChargesLeft(){
        return chargesLeft;
        // return maxNumberOfCharges - numberOfRubs
    }

    public int getNumberOfRecharges(){
        return chargesLeft;
    }

    public int getNumberOfRubs(){
        return chargesLeft;
    }

    public int getMaxNumberOfCharges(){
        return chargesLeft;
    }
    public Genie rub(int numberOfWishes){
        numberOfRubs++;
        if (chargesLeft <= 0){
            return new Demon(numberOfWishes);
        }else if (numberOfRubs % 2 == 0) {
            this.chargesLeft -= 1;
            return new GoodGenie(numberOfWishes);
        }else{
            this.chargesLeft -= 1;
            return new GrumpyGenie(numberOfWishes);
        }
    }

    public void recharge(Genie currentGenie){
        if (currentGenie instanceof Demon){

            chargesLeft = maxNumberOfCharges;
            numberOfRecharges++;
            ((Demon) currentGenie).hasBeenSacrificed = true;
            System.out.println(currentGenie.name + " the demon has been sacrificed and your lamp has been recharged.");
            return;
        }

        System.out.println("You can only recycle demons.");
    }

    public boolean compareLamps(Lamp lamp){
        return chargesLeft == lamp.chargesLeft &&
                maxNumberOfCharges == lamp.maxNumberOfCharges &&
                numberOfRecharges == lamp.numberOfRecharges;
    }
}
