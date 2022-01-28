package com.example.learn.function.function;

import sun.jvm.hotspot.utilities.Assert;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author xiuce
 * @version 1.0
 * @date 2021/12/29 3:26 下午
 * 定义了一个传递两个参数，返回一个参数的函数。如果三个值类型相同，可以使用BiOperator
 */
public class BiFunctionTest {

    static BiFunction<Integer, Integer, Integer> add = Integer::sum;
    static BiFunction<Integer, Integer, Integer> sub = (item1, item2) -> item1 - item2;
    static BiFunction<Integer, Integer, Integer> mul = (item1, item2) -> item1 * item2;
    static BiFunction<Integer, Integer, Integer> div = (item1, item2) -> item1 / item2;

    static Function<Integer, Integer> doubleThis = item -> item * 2;

    /**
     * apply, 执行函数
     */
    public static void testApply() {
        System.out.println(add.apply(2, 3));
        System.out.println(sub.apply(2, 3));
        System.out.println(mul.apply(2, 3));
        System.out.println(div.apply(2, 3));
    }

    /**
     * 返回一个复合函数，这个函数先执行当前函数，再执行andThen传递的函数，参数为第一个函数的返回值
     *
     */
    public static void testAndThen() {
        System.out.println(add.andThen(doubleThis).apply(2, 3));
    }

    public static void main(String[] args) {
        testApply();
        testAndThen();
    }
}
