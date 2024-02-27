package com.anshuman.functionalprogramming.lambda;

import java.util.function.BiFunction;

/**
 * A class with a single method "print" with fixed input type and return type.
 */
class MyFunctionPrint {
    public String print(Integer i) {
        return i.toString();
    }
}

/**
 * A class with a single method "apply" with a generic input type and a fixed return type.
 */
class MyFunctionGenOneArg<T> {

    public String apply(T t) {
        return t.toString();
    }
}

/**
 * A class with a single method "apply" with two generic inputs and a return type.
 */
class MyFunctionGenTwoArgs<T, U> {
    public String apply(T t, U u) {
        return t.toString() + " " + u.toString();
    }
}

/**
 * An interface with a single default method "apply" with two generic inputs and a return type.
 */
interface IMyFunctionGenTwoArgs<T, U> {
    default String apply(T t, U u) {
        return t.toString() + " " + u.toString();
    }
}

/**
 * An interface with a single overridden default method "apply" with two generic inputs and a return type.
 */
interface MyFunctionGenTwoArgsTwo<T, U> extends IMyFunctionGenTwoArgs<T, U> {

    @Override
    default String apply(T t, U u) {
        String tString = (t == null) ? "" : t.toString().strip();
        String uString = (u == null) ? "" : u.toString().strip();
        return tString + " " + uString;
    }
}

interface StringUtil {
    static String convert(Integer integer) {
        return (integer == null) ? "" : integer.toString();
    }

    static String strip(String string) {
        return (string == null) ? "" : string.strip();
    }

    static String multiInput(Integer stringOne, Integer stringTwo) {
        return strip(convert(stringOne)) + " " + strip(convert(stringTwo));
    }
}

public class LambdaEvolution {

    public static void main(String[] args) {
        System.out.println(new MyFunctionPrint().print(5));

        System.out.println(new MyFunctionGenOneArg<Integer>().apply(5));

        System.out.println(new MyFunctionGenTwoArgs<Integer, Integer>().apply(4, 5));

        System.out.println(new IMyFunctionGenTwoArgs<Integer, Integer>() {
        }.apply(4, 5));

        System.out.println(new MyFunctionGenTwoArgsTwo<Integer, Integer>() {
        }.apply(4, 5));

        BiFunction<Integer, Integer, String> stringBiFunction = (a, b) -> ((a == null) ? "" : a.toString().strip()) + " " + ((b == null) ? "" : b.toString().strip());
        System.out.println(stringBiFunction.apply(4, 5));

        BiFunction<Integer, Integer, String> stringBiFunctionMR = StringUtil::multiInput;
        System.out.println(stringBiFunctionMR.apply(4, 5));
    }


}



