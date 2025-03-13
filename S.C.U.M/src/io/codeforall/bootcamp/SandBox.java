package io.codeforall.bootcamp;

import java.util.Arrays;

public class SandBox {
    public static void main(String[] args) {

        MonoOperation<String> separateWords = something -> Arrays.toString(something.split(" "));
        BiOperation<String> concatenateWords = (something, somethingElse) -> (something + somethingElse);
        Machine myLittleMachine = new Machine(separateWords, concatenateWords);

        System.out.println(myLittleMachine.useMonoOperation("Hello World"));
        System.out.println(myLittleMachine.useBiOperation("ba", "tata"));
    }
}
