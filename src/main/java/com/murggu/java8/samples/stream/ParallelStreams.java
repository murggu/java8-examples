package com.murggu.java8.samples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Aitor Murguzur
 */
public class ParallelStreams {

    public static void main(String[] args) {

        int max = 100000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID id = UUID.randomUUID();
            values.add(id.toString());
        }

        sequentialSort(values);
        parallelSort(values);
    }

    private static void sequentialSort(List values) {
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    private static void parallelSort(List values) {
        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }
}
