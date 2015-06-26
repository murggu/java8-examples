package com.murggu.java8.samples.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Aitor Murguzur
 */
public class Streams3 {

    public static void main(String[] args) {

        /**
         * Reusing streams: Java 8 streams cannot be reused
         */

        // to overcome such limitation, we could create a stream supplier
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("val2", "bal2", "val1", "val3", "val4").filter(s ->
                s.startsWith("b"));

        // each get() constructs a new stream
        System.out.println(streamSupplier.get().anyMatch(s -> true));   // true
        System.out.println(streamSupplier.get().noneMatch(s -> true));  // false
    }
}
