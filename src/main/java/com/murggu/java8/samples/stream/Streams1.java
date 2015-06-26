package com.murggu.java8.samples.stream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Aitor Murguzur
 */
public class Streams1 {

    public static void main(String[] args) {

        /**
         * In this example:
         * - intermediate operations: filter, map, mapToInt, mapToLong, mapToDouble, mapToObj, sorted
         * - terminal operations: forEach, forEachOrdered
         * - short circ. terminal operations: findFirst
         */

        Arrays.stream(new String[]{"val11", "val2", "val3", "val4", "val1"})
                .filter(s -> s.contains("1"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        // we can also create a stream from a bunch of object references
        Stream.of("val11", "val2", "val3", "val4", "val1")
                .findFirst()
                .ifPresent(System.out::println);

        // streams for primitive data types: int, long and double and support the additional terminal operations
        // sum() and average()
        IntStream.range(1, 4)
                .forEachOrdered(System.out::println);

        LongStream.of(1, 2, 3)
                .forEach(System.out::println);

        DoubleStream.of(1.0, 2.0, 3.0)
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);

        // we can also transform a regular stream to a primitive stream using mapToInt(), mapToLong(), and mapToDouble()
        // and viceversa using mapToObj()
        Stream.of("val11", "val2", "val3", "val4", "val1")
                .map(s -> s.substring(3))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);    // 11

        IntStream.range(1, 4)
                .mapToObj(i -> "val" + i)
                .forEach(System.out::println);

        // or even combined
        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "val" + i)
                .forEach(System.out::println);
    }
}
