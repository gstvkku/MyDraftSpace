package io.codeforall.bootcamp;

public class Lamp {
    private int maxNumberOfCharges;
    private int numberOfRecharges;
    private int chargesLeft;

    private int numberOfRubs = 0;

    public Lamp(int maxNumberOfCharges) {
        if (maxNumberOfCharges != 0) {
            this.maxNumberOfCharges = maxNumberOfCharges;
            this.chargesLeft = maxNumberOfCharges;
            System.out.println("You found a magic lamp! You can rub it " + maxNumberOfCharges + " times.");
        } else {
            this.maxNumberOfCharges = maxNumberOfCharges;
            this.chargesLeft = maxNumberOfCharges;
            System.out.println("You found a demonic lamp! You can rub it how many times you want, " +
                    "but you need to be careful...");
        }
    }

    public int getChargesLeft() {
        return chargesLeft;
        // return maxNumberOfCharges - numberOfRubs
    }

    public int getNumberOfRecharges() {
        return chargesLeft;
    }

    public int getNumberOfRubs() {
        return chargesLeft;
    }

    public int getMaxNumberOfCharges() {
        return chargesLeft;
    }

    public Genie rub(int numberOfWishes) {
        numberOfRubs++;
        if (chargesLeft <= 0) {
            return new Demon(numberOfWishes);
        } else if (numberOfRubs % 2 == 0) {
            this.chargesLeft -= 1;
            return new FriendlyGenie(numberOfWishes);
        } else {
            this.chargesLeft -= 1;
            return new GrumpyGenie(numberOfWishes);
        }
    }

    public void recharge(Genie currentGenie) {
        if (currentGenie instanceof Demon && this.maxNumberOfCharges != 0) {
            chargesLeft = maxNumberOfCharges;
            numberOfRecharges++;
            ((Demon) currentGenie).hasBeenSacrificed = true;
            System.out.println(currentGenie.getName() + " the demon has been sacrificed and your lamp has been recharged.");
            return;
        }
        if (this.maxNumberOfCharges == 0) {
            System.out.println("You can't recharge demonic lamps!");
            return;
        } else {
            System.out.println("You can only sacrifice demons.");
        }
    }

    public boolean compareLamps(Lamp lamp) {
        return this.chargesLeft == lamp.chargesLeft &&
                this.maxNumberOfCharges == lamp.maxNumberOfCharges &&
                this.numberOfRecharges == lamp.numberOfRecharges;
    }
}
