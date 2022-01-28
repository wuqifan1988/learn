package com.example.learn.function.function;

import java.util.function.Function;

/**
 * @author xiuce
 * @version 1.0
 * @date 2021/12/29 3:14 下午
 */
public class FunctionTest {

    static Function<Integer, Integer> mul2function = item -> item * 2;
    static Function<Integer, Integer> add2function = item -> item + 2;

    public static void testApply() {
        System.out.println(mul2function.apply(3));
    }

    public static void testCompose() {
        System.out.println(add2function.compose(mul2function).apply(3));
        System.out.println(mul2function.compose(add2function).apply(3));
    }

    public static void testAndThen() {
        System.out.println(add2function.andThen(mul2function).apply(10));
    }


    public static void main(String[] args) {
        testApply();
        testCompose();
        testAndThen();
    }
}
