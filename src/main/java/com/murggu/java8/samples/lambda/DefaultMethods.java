package com.murggu.java8.samples.lambda;

/**
 * @author Aitor Murguzur
 */
public class DefaultMethods {

    public interface Calculator {

        double sum(int a, int b);

        default double sqrt(int a) {
            return Math.sqrt(a);
        }
    }

    public static void main(String[] args) {

        // Calculator is implemented as an anonymous object. It can be replaced by a lambda expr.

        Calculator calculatorAnonymous = new Calculator() {

            @Override
            public double sum(int a, int b) {
                return a + b;
            }
        };

        System.out.println(calculatorAnonymous.sum(100, 200)); // 300.0
        System.out.println(calculatorAnonymous.sqrt(16)); // 4.0

        Calculator calculatorLambda = (a, b) -> a + b;

        System.out.println(calculatorLambda.sum(100, 200)); // 300.0
        System.out.println(calculatorLambda.sqrt(16)); // 4.0
    }
}
