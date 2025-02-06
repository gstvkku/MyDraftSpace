package io.codeforall.bootcamp;

public class Game {
    public int gameNumber;
    public Player player;


    public Game(Player player1) {
        this.player = player1;
    }

    public void defineGameNumber() {
        this.gameNumber = Generator.generateNumber();
    }

    public void play() {
        System.out.println("Generating the game number...");
        defineGameNumber();
        player.definePlayerNumber();
        for (int rounds = 0; rounds < 5; rounds++) {
            if (player.getNumber() != gameNumber) {
                System.out.println("Wrong number - " + player.getNumber() + " :( Try again!");
            } else if (player.getNumber() == gameNumber) {
                System.out.println("Congratulations! You guessed the number - " + player.getNumber());
                break;
            }
            if (rounds == 4) {
                System.out.println("Game won :( the number was " + gameNumber);
            }
            player.definePlayerNumber();
        }
    }
}