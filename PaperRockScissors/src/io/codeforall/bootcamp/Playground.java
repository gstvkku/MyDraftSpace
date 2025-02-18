package io.codeforall.bootcamp;

public class Playground {
    public static void main(String[] args) {
        Game game = new Game(new Players("Gustavo"), new Players("Diogo"), 5);
        game.play();
    }
}