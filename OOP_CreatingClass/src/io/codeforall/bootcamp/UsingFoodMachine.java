package io.codeforall.bootcamp;

public class UsingFoodMachine {
    public static void main(String[] args) {

        // Day 1

        FoodMachine myFoodMachine = new FoodMachine("Chocolate Muffin", 5, 8345, 30);

        myFoodMachine.toSeeTheMenu();

        myFoodMachine.toTakeFood(10);

        myFoodMachine.toTakeFood(20);

        myFoodMachine.toTakeFood(15);

        myFoodMachine.toSeeMoreInfos(8345);

        myFoodMachine.toTakeFood(50);

        myFoodMachine.toTakeTheMoney(8345);

        //Day 2

        myFoodMachine.toPutFoodInside(8345, "Cheese Croissant");

        myFoodMachine.toDefinePrice(8345, 8);

        myFoodMachine.toSeeTheMenu();

        myFoodMachine.toTakeFood(10);

        myFoodMachine.toPutMoneyInside(8345, 25);

        myFoodMachine.toTakeFood(10);

        myFoodMachine.toTakeFood(15);

        myFoodMachine.toTakeTheMoney(8345);
    }
}