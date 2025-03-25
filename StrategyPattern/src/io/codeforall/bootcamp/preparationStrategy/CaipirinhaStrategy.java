package io.codeforall.bootcamp.preparationStrategy;

public class CaipirinhaStrategy implements PreparationStrategy{
    @Override
    public void execute() {
        System.out.println("Macerating lemon pieces...");
        System.out.println("Adding a spoonful of sugar...");
        System.out.println("Adding 50ml of cachaça...");
        System.out.println("Shaking...");
        System.out.println("Adding ice cubes...");
    }
}
