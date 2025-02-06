package io.codeforall.bootcamp;

public class Player {
    public String playerName;

    private int number;

    public Player(String name) {
        this.playerName = name;
        System.out.println("Welcome, " + this.playerName + "!");
    }

    public void definePlayerNumber() {
        this.number = Generator.generateNumber();
    }

    public int getNumber() {return this.number;}
}