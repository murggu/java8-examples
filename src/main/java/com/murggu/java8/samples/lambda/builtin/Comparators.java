package com.murggu.java8.samples.lambda.builtin;

import java.util.Comparator;

/**
 * @author Aitor Murguzur
 */
public class Comparators {

    public static void main(String[] args) {

        /**
         * Comparator imposes a total ordering on some collection of objects
         */

        Comparator<Racket> racketComparator = (r1, r2) -> r1.getBrand().compareTo(r2.getBrand());

        Racket wilson = new Racket("Blade", "Wilson");
        Racket head = new Racket("Radical", "Head");

        System.out.println(racketComparator.compare(wilson, head));
    }

    static class Racket {

        String name;
        String brand;

        Racket() {}

        Racket(String name, String brand) {
            this.name = name;
            this.brand = brand;
        }

        String getName() { return name; }

        String getBrand() { return brand; }
    }
}
