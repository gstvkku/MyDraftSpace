package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

public class CarFactory {
    private static int counter = 0;
    private static int maxNumOfAmbulances = 3;

    public static Car getNewCar() {
        if (maxNumOfAmbulances > 0) {
            maxNumOfAmbulances--;
            return new Ambulance(new Position(), 2);
        }
        if (counter % 2 == 0) {
            counter++;
            return new Fiat(new Position(), 1);
        } else {
            counter++;
            return new Mustang(new Position(), 3);
        }
    }
}
