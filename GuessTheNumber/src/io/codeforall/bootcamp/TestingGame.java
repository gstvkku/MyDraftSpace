package io.codeforall.bootcamp;

public class TestingGame {
    public static void main(String[] args) {
        Player player1 = new Player("Whatever");
        Game game = new Game(player1);
        game.play();
    }
}