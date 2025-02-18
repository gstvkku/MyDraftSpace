package io.codeforall.bootcamp.GameObjects;

public class Barrel extends GameObject implements Destroyable {
    public BarrelType barrelType;
    public int currentDamage;
    boolean isDestroyed = false;

    public Barrel(BarrelType barrelType) {
        this.barrelType = barrelType;
        System.out.println(getMessage());
    }

    @Override
    String getMessage() {
        return "Hey! I'm a barrel!";
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    public void hit(int damage) {
        calculateDamage(damage);
    }

    private void destroy(){
        isDestroyed = true;
        currentDamage = 0;
        System.out.println(getBarrelType() + " barrel was destroyed.");
    }

    public void calculateDamage(int damage) {
        if (currentDamage > 0 && currentDamage >= damage) {
            currentDamage -= damage;
            System.out.println(getBarrelType() + "barrel was hit.");
        } else {
            destroy();
        }
    }

    public String getBarrelType(){
        return this.barrelType.getBarrelTypeStr();
    }
}
