package com.anshuman.functionalprogramming.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lambdas {

    public static void lambdaNotations() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);

            }
        });

        //internal iterator with lambdas
        numbers.forEach((Integer value) -> System.out.println(value));

        /**
         * But not just that. Since we declared numbers as a collection of Integers in a list,
         * we don't need to declare that value's type is an Integer.
         * We can leave out the type most of the time.
         */
        numbers.forEach((value) -> System.out.println(value));

        /**
         * But there's more. Parenthesis is optional but only for one parameter lambdas.
         * 0 parameters and 2+ parameters require parenthesis.
         */
        numbers.forEach(value -> System.out.println(value));

        /**
         *  But there's more. Since we are just passing through the value without any operations,
         *  we can cut down code by removing the variable from both sides.
         *  So you use the method reference :: instead of lambdas.
         *  It means that we are passing the function, not invoking the function.
         *  It means that all your intention is that to receive the value and pass it on without modifying it.
         *
         */
        numbers.forEach(System.out::println);

    }
}
