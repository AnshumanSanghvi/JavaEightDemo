package com.anshuman.functionalprogramming;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Streams {
    public static void main(String[] args) {
        lazyEvaluation();
        specializedFunctions();
    }

    /**
     * Streams are evaluated lazily
     */
    public static void lazyEvaluation() {
        Instant start = Instant.now();
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .map(i -> {
                    sleep();
                    return i;
                });
        Instant end = Instant.now();
        System.out.println("Operation took: " + Duration.between(start, end).getSeconds() + " seconds");

        start = Instant.now();
        stream.toList();
        end = Instant.now();
        System.out.println("Operation took: " + Duration.between(start, end).getSeconds() + " seconds");
    }

    private static void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Specialized functions help the code concise
     */
    public static void specializedFunctions() {
        // for a map of names and scores, group them by scores.
        Map<String, Integer> scores = Map.of("Jack", 12, "Jill", 15, "Tom", 11, "Darla", 15, "Nick", 15, "Nancy", 11);

        // Imperative Style
        Map<Integer, List<String>> byScores = new HashMap<>();
        for (String name : scores.keySet()) {
            int score = scores.get(name);
            List<String> names = new ArrayList<>();
            if (byScores.containsKey(score)) {
                names = byScores.get(score);
            }
            names.add(name);
            byScores.put(score, names);
        }
        System.out.println(byScores);

        // Functional Style (using "java.util.stream.Collectors.groupingBy")
        System.out.println(scores.keySet().stream().collect(groupingBy(scores::get)));
    }


}
