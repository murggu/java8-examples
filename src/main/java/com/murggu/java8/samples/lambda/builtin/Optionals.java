package com.murggu.java8.samples.lambda.builtin;

import java.util.Optional;

/**
 * @author Aitor Murguzur
 */
public class Optionals {

    public static void main(String[] args) {

        /**
         * Optional is not exactly a functional interface, it's an utility to prevent
         * NullPointerException.
         */

        Optional<Integer> optional = Optional.of(5);

        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        optional.ifPresent(System.out::println);
    }
}
