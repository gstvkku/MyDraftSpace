package io.codeforall.bootcamp.GameObjects;

public class ArmouredEnemy extends Enemy {
    private int armour;

    public ArmouredEnemy(int health, int armour) {
        super(health);
        this.armour = armour;
    }

    @Override
    public void hit(int damage) {
        super.calculateHealth(calculateArmour(damage));
    }

    private int calculateArmour(int damage) {
        if (armour > 0 && damage <= armour) {

            armour -= damage;
            System.out.println("Enemy was hit, its armour is now: " + armour);
            return 0;
        } else {
            if (armour != 0){
                System.out.println("Enemy armour was destroyed!");
            }
            damage -= armour;
            armour = 0;
            return damage;
        }
    }
    @Override
    String getMessage() {
        return "Hey! I'm a armoured enemy!";
    }
}
