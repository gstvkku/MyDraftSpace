package io.codeforall.bootcamp.preparationStrategy;

public class NegroniStrategy implements PreparationStrategy{
    @Override
    public void execute() {
        System.out.println("Adding 50ml of gim...");
        System.out.println("Adding 50ml of Campari...");
        System.out.println("Adding 50ml of red vermouth...");
        System.out.println("Adding an orange slice...");
    }
}
