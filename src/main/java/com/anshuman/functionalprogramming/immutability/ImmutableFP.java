package com.anshuman.functionalprogramming.immutability;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class ImmutableFP {

    public static void main(String[] args) {
        listOfNumbers();
        applyMethodsToObject();
    }

    private static void listOfNumbers() {
        // no external iterator like i in a for loop
        // no extra work or code or for-loop details to be remembered
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.forEach(System.out::println);
    }

    public static Function<String, String> fixDots = str -> str.replaceAll("\\.\\.", ".");

    public static Function<String, String> fixSpaces = str -> str.replaceAll("  ", " ");

    public static Function<String, String> fixCase = String::toUpperCase;

    public static void applyMethodsToObject() {
        System.out.println(
                Stream.of("  rAVINdRA  S..  JadejA   ")
                        .map(fixCase)
                        .map(fixDots)
                        .map(fixSpaces)
                        .map(String::strip)
                        .findFirst()
                        .orElseThrow()
        );

    }
}
