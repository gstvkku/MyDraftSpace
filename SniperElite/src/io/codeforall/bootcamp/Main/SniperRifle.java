package io.codeforall.bootcamp.Main;

import io.codeforall.bootcamp.GameObjects.Barrel;
import io.codeforall.bootcamp.GameObjects.Destroyable;

public class SniperRifle {
    private int bulletDamage = 75;

    public SniperRifle(int bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

    public void shoot(Destroyable destroyableObject) {
        System.out.println((destroyableObject instanceof Barrel)? "You shot at a barrel." :"You shot at an enemy.");
        if (didTheBulletHitTheEnemy()) {
            if (wasCriticalShot()) {
                destroyableObject.hit(Integer.MAX_VALUE);
                return;
            }
            destroyableObject.hit(bulletDamage);
        }
    }

    public boolean shootUntilDestroyed(Destroyable enemy){
        while (!enemy.isDestroyed()){
            shoot(enemy);
        }
        return true;
    }

    private boolean didTheBulletHitTheEnemy() {
        double randomNum = Math.random();
        if (randomNum < 0.75) {
            return true;
        } else {
            System.out.println("Your bullet missed the enemy!");
            return false;
        }
    }

    private boolean wasCriticalShot() {
        double randomNum = Math.random();
        if (randomNum < .25) {
            System.out.println("Critical shot!");
            return true;
        }
        return false;
    }
}
