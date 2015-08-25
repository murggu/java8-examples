package com.murggu.java8.samples.lambda.builtin;

import java.util.function.Predicate;

/**
 * @author Aitor Murguzur
 */
public class Predicates {

    public static void main(String[] args) {

        /**
         * Predicates are boolean-valued functions of one argument
         */

        Predicate<Integer> predicate1 = (i) -> i > 0;

        System.out.println(predicate1.test(0)); // false
        System.out.println(predicate1.negate().test(0)); // true

        Predicate<Integer> predicate2 = (i) -> i != null;

        System.out.println(predicate2.and(predicate1).test(2));
        System.out.println(predicate2.or(predicate1).test(4));
    }
}
