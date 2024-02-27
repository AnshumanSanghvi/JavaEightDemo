package com.anshuman.functionalprogramming.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctions {

    private static final BiFunction<MovieType, Integer, Integer> computePrice = (type, days) -> type.priceFunction.apply(days);

    public static void main(String[] args) {
        System.out.println(computePrice.apply(MovieType.NEW, 5));
        System.out.println(computePrice.apply(MovieType.REGULAR, 2));
        System.out.println(computePrice.apply(MovieType.CHILDREN, 4));
    }

    public enum MovieType {

        REGULAR(PriceCalculator.regularPriceCalcFunc),
        CHILDREN(PriceCalculator.childrenPriceCalcFunc),
        NEW(PriceCalculator.newPriceCalcFunc);

        private final Function<Integer, Integer> priceFunction;

        MovieType(Function<Integer, Integer> priceFunction) {
            this.priceFunction = priceFunction;
        }

    }

    public static class PriceCalculator {
        public static Function<Integer, Integer> regularPriceCalcFunc = days -> days + 1;
        public static Function<Integer, Integer> childrenPriceCalcFunc = days -> 5;
        public static Function<Integer, Integer> newPriceCalcFunc = days -> days * 2;
    }
}
