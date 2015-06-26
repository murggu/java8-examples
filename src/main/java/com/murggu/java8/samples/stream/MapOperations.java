package com.murggu.java8.samples.stream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aitor Murguzur
 */
public class MapOperations {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        for (int i =0; i < 10; i++) {
            // prevent us from writing additional if null checks
            map.putIfAbsent(i, "val" + i);
        }

        // forEach accepts a consumer
        map.forEach((id, val) -> System.out.println(val));

        // computing entries
        map.computeIfPresent(4, (num, val) -> val + num);
        System.out.println(map.get(4));

        map.computeIfPresent(4, (num, val) -> null);
        System.out.println(map.containsKey(4));

        map.computeIfAbsent(10, num -> "val" + num);
        System.out.println(map.containsKey(10));

        map.forEach((id, val) -> System.out.println(val));

        map.computeIfAbsent(10, num -> "bal" + num);
        System.out.println(map.get(10));

        // removing entries for a a given key, only if it's currently mapped to a given value
        map.remove(10, "bal10");
        System.out.println(map.get(10));

        map.remove(10, "val10");
        System.out.println(map.get(10));

        // getOrDefault
        System.out.println(map.getOrDefault(10, "not found"));

        // merging map entries
        map.merge(10, "val10", String::concat);
        System.out.println(map.get(10));

        map.merge(10, "newValue", String::concat);
        System.out.println(map.get(10));
    }
}
