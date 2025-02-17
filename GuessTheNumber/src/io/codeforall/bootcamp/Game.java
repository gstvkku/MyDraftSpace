package io.codeforall.bootcamp;

public class Game {
    private int gameNumber;
    public Player player;


    public Game(Player player1) {
        this.player = player1;
    }

    public void defineGameNumber() {
        this.gameNumber = Generator.generateNumber();
    }

     public void play() {
        System.out.println("Let's start the game!");
        System.out.println("Generating the game number...");
        defineGameNumber();
        player.definePlayerNumber();
        for (int rounds = 0; rounds < 5; rounds++) {
            if (player.getPlayerNumber() != gameNumber) {
                System.out.println("Wrong number - " + player.getPlayerNumber() + " :( Try again!");
            }
            else if (player.getPlayerNumber() == gameNumber) {
                System.out.println("You guessed the number - " + player.getPlayerNumber() + " :) Congratulations!");
                break;
            }
            if (rounds == 4) {
                System.out.println("Game won :( the number was " + gameNumber);
            }
            player.definePlayerNumber();
        }
    }
}