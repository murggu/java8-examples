package com.murggu.java8.samples.lambda;

/**
 * @author Aitor Murguzur
 */
public class MethodAndConstructorReferenfes {

    public static void main(String[] args) {

        /**
         * We are using a static method reference here instead of a lambda expr.
         */
        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer converted1 = converter1.convert("987");
        System.out.println(converted1);

        // Similarly we can also reference object methods
        Racket racket = new Racket();
        Converter<String, String> converter2 = racket::startsWith;
        String converted2 = converter2.convert("Wilson");
        System.out.println(converted2);

        // Or even constructors
        RacketFactory<Racket> racketFactory = Racket::new;
        Racket wilsonBlade = racketFactory.create("Blade", "Wilson");
    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    static class Racket {

        String name;
        String brand;

        Racket() {}

        Racket(String name, String brand) {
            this.name = name;
            this.brand = brand;
        }

        String startsWith (String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface RacketFactory<R extends Racket> {
        R create(String name, String brand);
    }
}
