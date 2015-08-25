package com.murggu.java8.samples.lambda.builtin;

import java.util.function.Function;

/**
 * @author Aitor Murguzur
 */
public class Functions {

    public static void main(String[] args) {

        /**
         * Functions accept one argument and produce a result
         */

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(backToString.apply("987")); // "987"

        Function<Integer, Integer> add3 = (a) -> a + 3;
        Function<Integer, Integer> times2 = (a) -> a * 2;

        Function<Integer, Integer> composedA = add3.compose(times2);
        Function<Integer, Integer> composedB = times2.compose( add3 ) ;

        System.out.println(composedA.apply(6)) ;  // ( 6 * 2 ) + 3
        System.out.println(composedB.apply(6)) ;  // ( 6 + 3 ) * 2
    }
}
