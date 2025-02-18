package io.codeforall.bootcamp.GameObjects;

import io.codeforall.bootcamp.GameObjects.GameObject;

public class Tree extends GameObject {
    public Tree() {
        System.out.println(getMessage());
    }

    String getMessage() {
        return "Hey! I'm a tree!";
    }
}
