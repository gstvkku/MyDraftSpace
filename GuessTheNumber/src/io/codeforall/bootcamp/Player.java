package io.codeforall.bootcamp;

public class Player {
    public String playerName;

    private int playerNumber;

    public Player(String name) {
        this.playerName = name;
        System.out.println("Welcome, " + this.playerName + "!");
    }

    public void definePlayerNumber() {
        this.playerNumber = Generator.generateNumber();
    }

    public int getPlayerNumber() {return this.playerNumber;}
}