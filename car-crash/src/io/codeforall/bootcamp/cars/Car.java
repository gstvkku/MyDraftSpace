package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

abstract public class Car {

    private final Position POS;
    private Directions dir;
    private final int SPEED;
    private boolean isCrashed = false;
    private int numberOfMoves = 0;

    public Car(Position position, int speed) {
        this.POS = position;
        this.SPEED = speed;
    }

    public Position getPos() {
        return POS;
    }

    public Directions getDir() {
        return dir;
    }

    public void setDir(Directions dir) {
        this.dir = dir;
    }

    public int getSpeed() {
        return SPEED;
    }

    public boolean getIsCrashed() {
        return isCrashed;
    }

    public void setIsCrashed(boolean crashed) {
        isCrashed = crashed;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }
}
