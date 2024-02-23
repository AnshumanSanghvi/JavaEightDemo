package com.anshuman.functionalprogramming.immutability;

import java.util.Arrays;
import java.util.List;

public class MutableItr {

    public static void main(String[] args) {
        listOfNumbers();
        transferObjectBetweenMethods();
    }

    private static void listOfNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < numbers.size(); i++) {
            int temp = numbers.get(i) * 2;
            // `i` is mutable : so you have to take care of it's state. you or anyone can change the value of i within the loop
            // you actually don't need anything to do with i as a variable, you're just using it to use as a counter.
        }
    }

    private static void transferObjectBetweenMethods() {
        String dirty = "  rAVINdRA  S..  JadejA   ";
        dirty = fixDots(dirty);
        dirty = fixSpaces(dirty);
        dirty = fixCase(dirty);
        dirty = dirty.strip();
        dirty = null; // !!!!!!!!!!
        System.out.println(dirty);
    }

    private static String fixDots(String input) {
        return input.replaceAll("\\.\\.", ".");
    }

    private static String fixSpaces(String input) {
        return input.replaceAll("  ", " ");
    }

    private static String fixCase(String input) {
        return input.toUpperCase();
    }
}
