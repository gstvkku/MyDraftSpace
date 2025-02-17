package io.codeforall.bootcamp.GameObjects;

public enum BarrelType {
    PLASTIC(50, "plastic"),
    WOOD(100, "wood"),
    METAL(150, "metal");

    private int maxDamage;
    private String barrelType;

    BarrelType(int maxDamage, String barrelType) {
        this.maxDamage = maxDamage;
        this.barrelType = barrelType;
    }

    public int getMaxDamage() {
        return maxDamage;
    }
    public String getBarrelTypeStr(){
        return barrelType;
    }
}

