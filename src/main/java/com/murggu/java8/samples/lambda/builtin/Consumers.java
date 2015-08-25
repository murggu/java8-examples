package com.murggu.java8.samples.lambda.builtin;

import java.util.function.Consumer;

/**
 * @author Aitor Murguzur
 */
public class Consumers {

    public static void main(String[] args) {

        /**
         * Consumers represents operations to be performed on a single input argument
         */

        Consumer<Racket> wilsonBlade = (r) -> System.out.println("Nice racket " + r.composedName());
        wilsonBlade.accept(new Racket("Blade", "Wilson"));
    }

    static class Racket {

        String name;
        String brand;

        Racket() {}

        Racket(String name, String brand) {
            this.name = name;
            this.brand = brand;
        }

        public String composedName() {
            return brand + " " + name;
        }
    }
}
