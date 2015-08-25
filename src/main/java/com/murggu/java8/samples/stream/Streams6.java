package com.murggu.java8.samples.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aitor Murguzur
 */
public class Streams6 {

    public static void main(String[] args) {

        /**
         * reduce terminal operation
         */

        // reduces a stream of elements into a exactly one element of the stream

        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        persons.stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);

    }

    static  class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
