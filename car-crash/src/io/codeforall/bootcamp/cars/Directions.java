package io.codeforall.bootcamp.cars;

public enum Directions {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    public static Directions generateDirection() {
        return values()[(int) (Math.random() * values().length)];
    }
}


