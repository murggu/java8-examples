package com.murggu.java8.samples.misc;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Aitor Murguzur
 */
public class Annotations {

    @Retention(RetentionPolicy.RUNTIME)
    @interface Annots {
        Annot[] value();
    }

    @Repeatable(Annots.class)
    @interface Annot {
        String value();
    }

    // New school. Old school was @Annots({@Annot("annot1"), @Annot("annot2")})
    @Annot("annot1")
    @Annot("annot2")
    class Racket {

    }

    public static void main(String[] args) {

        System.out.println(Racket.class.getAnnotation(Annots.class));
    }
}
