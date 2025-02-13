package io.codeforall.bootcamp;

public class Genie {
    public int numberOfWishes;

    public String name;

    public Genie(int numberOfWishes){
        this.numberOfWishes = numberOfWishes;
        this.name = randomName();

    }

    public String randomName(){
        int random = (int) Math.floor(Math.random() * 5) + 1;
        String name = "";

        switch (random){
            case 1:
                name = "Zafirah";
                break;
            case 2:
                name = "Jamilah";
                break;
            case 3:
                name = "Kasim";
                break;
            case 4:
                name = "Rafiq";
                break;
            case 5:
                name = "Miraaz";
                break;
        }

        name += " ";

        random = (int) Math.floor(Math.random() * 5) + 1;

        switch (random){
            case 1:
                name += "Al-Fayez";
                break;
            case 2:
                name += "Zahra";
                break;
            case 3:
                name += "Dahran";
                break;
            case 4:
                name += "Al-Jinn";
                break;
            case 5:
                name += "Sultani";
                break;
        }

        return name;
    }

    public void grantAWish(String wish){
        if (numberOfWishes > 0) {
            numberOfWishes--;
            System.out.println("Your wish - " + wish + " - has been granted by the great " + name + ".");
            System.out.println("You have " + numberOfWishes + " wishes left.");
            return;
        }
        System.out.println("You have no more wishes left.");
    }
}
