package io.codeforall.bootcamp.GameObjects;

public class GameObjectsFactory {
    public static GameObject createGameObject() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber < 4) {
            return new SoldierEnemy(100);
        }
        if (randomNumber < 8) {
            return new ArmouredEnemy(100, 50);
        }
        if (randomNumber < 9) {
            return new Barrel(BarrelType.values()[(int) (Math.random() * BarrelType.values().length)]);
        }
        return new Tree();
    }
}
