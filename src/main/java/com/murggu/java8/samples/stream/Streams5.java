package com.murggu.java8.samples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Aitor Murguzur
 */
public class Streams5 {

    public static void main(String[] args) {

        /**
         * FlatMap intermediate operation. Transforms each element of the stream into a stream of other objects.
         * Optional flatMap operation can be utilized to prevent nasty null checks.
         */

        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Car("Car" + i + " <- " + f.name))
                        .forEach(f.cars::add))
                .flatMap(f -> f.cars.stream())
                .forEach(b -> System.out.println(b.name));
    }

    static class Foo {
        String name;
        List<Car> cars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    static class Car {
        String name;

        Car(String name) {
            this.name = name;
        }
    }
}
