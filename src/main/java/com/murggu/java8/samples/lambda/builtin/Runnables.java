package com.murggu.java8.samples.lambda.builtin;

/**
 * @author Aitor Murguzur
 */
public class Runnables {

    public static void main(String[] args) {

        Runnable task1 = () -> System.out.println(Thread.currentThread().getName() + " is running");

        Runnable task2 = () -> System.out.println(Thread.currentThread().getName() + " is running");

        new Thread(task1).start();
        new Thread(task2).start();
    }
}
