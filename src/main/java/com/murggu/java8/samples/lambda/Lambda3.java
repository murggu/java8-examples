package com.murggu.java8.samples.lambda;

/**
 * @author Aitor Murguzur
 */
public class Lambda3 {

    static int outerStaticNum;
    int outerNum;

    void testLocalVariables() {
        // num does not have to be explicitly final
        int num = 1;

        Converter<Integer, String> stringConverterLocal = (from) -> String.valueOf(from + num);
        String s = stringConverterLocal.convert(2);
        System.out.println(s);

        // num mut be implicitly final
        // num = 7 will not compile
    }

    void testFieldsAndStaticVariables() {
        Converter<Integer, String> stringConverterOuter = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        String s23 = stringConverterOuter.convert(23);
        System.out.println(s23);

        Converter<Integer, String> stringConverterStatic = (from) -> {
            outerStaticNum = 32;
            return String.valueOf(from);
        };

        String s32 = stringConverterStatic.convert(32);
        System.out.println(s32);
    }

    public static void main(String[] args) {

        /**
         * Lambda scopes
         */

        // 1) Accessing local variables
        new Lambda3().testLocalVariables();

        // 2) Accessing fields and static variables
        new Lambda3().testFieldsAndStaticVariables();

        // 3) Defaults methods cannot be accessed form within lambda expressions

    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }
}
