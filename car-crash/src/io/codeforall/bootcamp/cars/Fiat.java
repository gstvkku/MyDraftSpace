package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

public class Fiat extends Car {

    public Fiat(Position position, int speed) {
        super(position, speed);
    }

    @Override
    public String toString() {
        return getIsCrashed() ? "C" : "F";
    }
}
