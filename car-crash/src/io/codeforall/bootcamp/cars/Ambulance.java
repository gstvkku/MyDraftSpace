package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

public class Ambulance extends Car {
    public Ambulance(Position position, int speed) {
        super(position, speed);
    }

    @Override
    public String toString() {
        return "A";
    }
}
