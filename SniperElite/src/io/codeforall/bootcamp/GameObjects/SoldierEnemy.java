package io.codeforall.bootcamp.GameObjects;

import io.codeforall.bootcamp.GameObjects.Enemy;

public class SoldierEnemy extends Enemy {
    public SoldierEnemy(int health) {
        super(health);
    }

    @Override
    public void hit(int damage) {
        super.calculateHealth(damage);
    }
    @Override
    String getMessage() {
        return "Hey! I'm a soldier enemy!";
    }
}
