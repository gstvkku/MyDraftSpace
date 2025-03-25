package io.codeforall.bootcamp.preparationStrategy;

public class DryMartiniStrategy implements PreparationStrategy{
    @Override
    public void execute() {
        System.out.println("Adding 150ml of gim...");
        System.out.println("Adding 25ml of dry vermouth...");
        System.out.println("Shaking...");
        System.out.println("Adding ice cubes...");
        System.out.println("Finishing with an olive...");
    }
}
