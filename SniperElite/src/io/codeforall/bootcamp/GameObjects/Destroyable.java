package io.codeforall.bootcamp.GameObjects;

public interface Destroyable {

    boolean isDestroyed();

    void hit(int damage);
}
