package com.murggu.java8.samples.stream;

import java.util.stream.Stream;

/**
 * @author Aitor Murguzur
 */
public class Streams2 {

    public static void main(String[] args) {

        /**
         * map and filter intermediate operations (executed vertically)
         */
        // each elements moves along the chain vertically
        Stream.of("val2", "bal2", "val1", "val3", "val4")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s)); // val2, val2, bal2, bal2, etc.

        // order matters :-)
        Stream.of("val2", "bal2", "val1", "val3", "val4")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("B");
                });

        Stream.of("val2", "bal2", "val1", "val3", "val4")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("B");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // we can optimize the chain above
        Stream.of("val2", "bal2", "val1", "val3", "val4")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("b");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        /**
         * sorted intermediate operation (executed vertically)
         */
        // note: sorted is executed horizontally and not vertically
        Stream.of("val2", "bal2", "val1", "val3", "val4")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("b");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // we can optimize the chain above
        Stream.of("val2", "bal2", "val1", "val3", "val4")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("b");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
