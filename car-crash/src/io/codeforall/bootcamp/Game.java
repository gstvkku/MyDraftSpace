package io.codeforall.bootcamp;

import io.codeforall.bootcamp.cars.*;
import io.codeforall.bootcamp.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 22;

    /**
     * Container of Cars
     */
    private static Car[] cars;

    /**
     * Animation delay
     */
    private int delay;

    private int cols;

    private int rows;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;
        this.cols = cols;
        this.rows = rows;

    }

    public Car[] getCars() {
        return cars;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            // Update screen
            Field.draw(cars);

        }

    }

    private void moveAllCars() {
        for (Car car : cars) {
            if (car instanceof Ambulance) {
                for (int i = car.getSpeed(); i > 0; i--) {
                    moveCar(car);
                }

            } else if (car instanceof Fiat) {
                for (int i = car.getSpeed(); i > 0; i--) {
                    moveCar(car);
                }
            } else {
                for (int i = car.getSpeed(); i > 0; i--) {
                    moveCar(car);
                }
            }
        }
    }

    public void moveCar(Car car) {
        if (!beforeMove(car)) {
            return;
        }
        switch (car.getDir()) {
            case UP:
                if (car.getPos().getRow() == 0) {
                    car.setDir(Directions.DOWN);
                    break;
                }
                car.getPos().setRow(car.getPos().getRow() - 1);
                car.setNumberOfMoves(car.getNumberOfMoves() - 1);
                crashVerify(car);
                break;

            case DOWN:
                if (car.getPos().getRow() == rows - 1) {
                    car.setDir(Directions.UP);
                    break;
                }
                car.getPos().setRow(car.getPos().getRow() + 1);
                car.setNumberOfMoves(car.getNumberOfMoves() - 1);
                crashVerify(car);
                break;

            case RIGHT:
                if (car.getPos().getCol() == cols - 1) {
                    car.setDir(Directions.LEFT);
                    break;
                }
                car.getPos().setCol(car.getPos().getCol() + 1);
                car.setNumberOfMoves(car.getNumberOfMoves() - 1);
                crashVerify(car);
                break;

            case LEFT:
                if (car.getPos().getCol() == 0) {
                    car.setDir(Directions.RIGHT);
                    break;
                }
                car.getPos().setCol(car.getPos().getCol() - 1);
                car.setNumberOfMoves(car.getNumberOfMoves() - 1);
                crashVerify(car);
                break;

        }
    }

    public boolean beforeMove(Car car) {
        if (car.getIsCrashed()) {
            return false;
        }
        if (car.getNumberOfMoves() == 0) {
            car.setDir(Directions.generateDirection());
            int numOfMoves = (int) (Math.floor(Math.random() * 10) + 9);
            car.setNumberOfMoves(numOfMoves);
        }
        return true;
    }

    public void crashVerify(Car car) {

        if (car instanceof Ambulance) {
            for (Car carElement : cars) {
                if (car.getPos().getRow() == carElement.getPos().getRow() &&
                        car.getPos().getCol() == carElement.getPos().getCol()) {
                    carElement.setIsCrashed(false);
                }
            }
            return;
        }
        for (Car carElement : cars) {
            if (car.equals(carElement) || carElement instanceof Ambulance) {
                continue;
            }
            if (car.getPos().getRow() == carElement.getPos().getRow() &&
                    car.getPos().getCol() == carElement.getPos().getCol()) {
                car.setIsCrashed(true);
                carElement.setIsCrashed(true);
            }
        }
    }
}




