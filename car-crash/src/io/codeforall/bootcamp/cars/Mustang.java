package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

public class Mustang extends Car {
    public Mustang(Position position, int speed) {
        super(position, speed);
    }

    @Override
    public String toString() {
        return getIsCrashed() ? "C" : "M";
    }
}
