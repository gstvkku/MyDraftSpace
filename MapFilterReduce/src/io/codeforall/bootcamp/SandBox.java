package io.codeforall.bootcamp;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SandBox {
    public static void main(String[] args) {

        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        String newMessage = Stream.of(message.split(" "))
                .map(word -> word.toUpperCase())
                .filter(word -> !word.equals("GARBAGE"))
                .reduce("", (acc, word) -> (acc + " " + word));

        System.out.println(newMessage);

    }

}


