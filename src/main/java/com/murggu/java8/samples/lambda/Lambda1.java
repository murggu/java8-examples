package com.murggu.java8.samples.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Aitor Murguzur
 */
public class Lambda1 {

    public static void main(String[] args) {

        /**
         * From anonymous objects to lambda expressions
         */

        List<String> rackets = Arrays.asList("Wilson", "Babolat", "Head", "Prince");

        /*Collections.sort(rackets, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(a1);
            }
        });*/

        Collections.sort(rackets, (o1, o2) -> o2.compareTo(o1));
    }
}
