package io.codeforall.bootcamp.GameObjects;

public abstract class Enemy extends GameObject implements Destroyable {
    private int health = 100;
    private boolean isDestroyed = false;

    public Enemy(int health) {
        this.health = health;
        System.out.println(getMessage());
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    String getMessage() {
        return null;
    }

    public void calculateHealth(int damage) {
        if (health > 0 && health > damage) {
            health -= damage;
            System.out.println("Enemy was hit, its health is now: " + health);
        } else {
            killEnemy();
            System.out.println("Enemy executed!");
        }
    }

    public void killEnemy() {
        health = 0;
        setDestroyed(true);
    }
}
