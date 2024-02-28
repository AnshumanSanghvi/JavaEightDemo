package com.anshuman.functionalprogramming.lambda;

import java.util.function.*;

public class Currying {

    /**
     * A curried function is a function that keeps returning functions until all its params are fulfilled
     */
    interface CurriedFunction<A, B> {
        public B apply(final A a);
    }

    private static void curryingExample1() {

        System.out.println(" \n### Example 1");

        CurriedFunction<Integer, CurriedFunction<Integer, Integer>> curriedAdd =
                new CurriedFunction<Integer, CurriedFunction<Integer, Integer>>() {
                    @Override
                    public CurriedFunction<Integer, Integer> apply(final Integer a) {
                        return new CurriedFunction<Integer, Integer>() {
                            @Override
                            public Integer apply(final Integer b) {
                                return a + b;
                            }
                        };
                    }
                };

        System.out.println(curriedAdd.apply(4));

        CurriedFunction<Integer, Integer> adder5 = curriedAdd.apply(4);
        System.out.println(adder5.apply(5));

        System.out.println(curriedAdd.apply(6).apply(7));
    }

    private static void curryingExample2() {

        System.out.println(" \n### Example 2");

        Function<Integer, Function<Integer, Integer>> curriedAdd = a -> (b -> a + b);

        System.out.println(curriedAdd.apply(4));

        System.out.println(curriedAdd.apply(6).apply(7));

    }

    private static void curryingExample3() {

        System.out.println(" \n### Example 3");

        Function<Integer, Function<Integer, Function<Integer, Integer>>> superCurriedMultiply = a -> b -> c -> b * c;

        System.out.println(superCurriedMultiply.apply(2).apply(3).apply(4));

    }

    public static void main(String[] args) {

        curryingExample1();

        curryingExample2();

        curryingExample3();
    }


}



