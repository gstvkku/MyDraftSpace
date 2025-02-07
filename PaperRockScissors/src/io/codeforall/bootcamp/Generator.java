package io.codeforall.bootcamp;

public class Generator {
    public static Moves generateMove() {
        return Moves.values()[(int) Math.floor(Math.random() * 3)];
    }
}