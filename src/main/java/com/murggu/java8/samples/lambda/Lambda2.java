package com.murggu.java8.samples.lambda;

/**
 * @author Aitor Murguzur
 */
public class Lambda2 {

    public static void main(String[] args) {

        /**
         * Using @FunctionalInterface annotation. A so called functional interface must contain
         * exactly one abstract method declaration.
         */

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);
    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }
}
