package io.codeforall.bootcamp;

public class Playground {
    public static void main(String[] args) {
        Players player1 = new Players("Gustavo");
        Players player2 = new Players("Diogo");
        Game game = new Game(player1, player2, 5);
        game.play();
    }
}