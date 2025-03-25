package io.codeforall.bootcamp.preparationStrategy;

public class MoscowMuleStrategy implements PreparationStrategy{
    @Override
    public void execute() {
        System.out.println("Adding 45ml of vodka...");
        System.out.println("Adding 10ml of lime juice...");
        System.out.println("Adding 90ml of fresh ginger beer...");
    }
}
