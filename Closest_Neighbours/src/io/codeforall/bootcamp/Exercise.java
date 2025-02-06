package io.codeforall.bootcamp;

public class Exercise {
    public static void main(String[] args) {

        int[] numbers = {0, 5, 1209, 6, 2, 111, 112, 33};
        int firstNumber = 0;
        int secondNumber = 0;
        int minDifference = Math.abs(numbers[0] - numbers[1]);

        for (int i = 1; i < numbers.length; i++) {
            int difference = Math.abs(numbers[i] - numbers[i - 1]);
            if (difference < minDifference) {
                minDifference = difference;
                firstNumber = numbers[i - 1];
                secondNumber = numbers[i];
            }
        }
        System.out.println(firstNumber);
        System.out.println(secondNumber);
    }
}

