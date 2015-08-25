package com.murggu.java8.samples.lambda.builtin;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Aitor Murguzur
 */
public class Suppliers {

    public static void main(String[] args) {

        /**
         * Suppliers produce a result of a given generic type. Don't accept arguments
         */

        Supplier<Racket> racketSupplier = Racket::new;
        System.out.println(racketSupplier.get());

        List rackets = Arrays.asList("Wilson", "Head", "Prince", "Babolat");
        rackets.stream().forEach((x) -> printBrands(() -> x));
    }

    static void printBrands(Supplier arg) {
        System.out.println(arg.get());
    }

    static class Racket {

        String name;
        String brand;
    }
}
