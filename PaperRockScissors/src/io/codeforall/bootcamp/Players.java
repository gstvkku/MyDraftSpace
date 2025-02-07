package io.codeforall.bootcamp;

public class Players {
    public String playerName;
    private Moves move;

    public Players(String playerName) {
        this.playerName = playerName;
        System.out.println("Welcome, " + this.playerName + "!");
    }
    public void defineMove() {
        this.move = Generator.generateMove();
    }
    public Moves getMove() {
        return this.move;
    }
}