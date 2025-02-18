package io.codeforall.bootcamp.Main;

import io.codeforall.bootcamp.GameObjects.*;

public class Game {
    private final int numberOfGameObjects;
    private final GameObject[] gameObjects;
    SniperRifle sniperRifle;

    private int shotsFired;

    public Game(int numberOfGameObjects) {
        this.numberOfGameObjects = numberOfGameObjects;
        gameObjects = new GameObject[numberOfGameObjects];
        sniperRifle = new SniperRifle(75);
    }

    public void start() {
        createObjects();
        startShooting();
    }

    private void startShooting(){
        for(int i = 0; i < gameObjects.length; i++){
            GameObject object = gameObjects[i];
            if (object instanceof Tree){
                System.out.println("You are looking at a tree.");
                continue;
            }
            if (object instanceof Barrel) {
                System.out.println("You saw a "+((Barrel) object).getBarrelType()+" explosive barrel.");
            }
            if (object instanceof SoldierEnemy)
                System.out.println("You saw a soldier enemy.");
            if (object instanceof ArmouredEnemy)
                System.out.println("You saw an armored enemy.");

            if (sniperRifle.shootUntilDestroyed((Destroyable) object) && object instanceof Barrel) {
                if (gameObjects[i + 1] instanceof Enemy) {
                    ((Enemy) gameObjects[i + 1]).killEnemy();
                    i++;
                    System.out.println("The explosive barrel exploded and killed an enemy.");
                }
            }
        }
    }

    private void createObjects() {
        for (int i = 0; i < numberOfGameObjects; i++){
            gameObjects[i] = GameObjectsFactory.createGameObject();
        }
    }
}
