package com.example.learn.function.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author xiuce
 * @version 1.0
 * @date 2021/12/29 3:36 下午
 */
public class BinaryOperatorTest {

    static BinaryOperator<Integer> add = Integer::sum;

    public static void testApply() {
        System.out.println(add.apply(1, 2));
    }

    public static void testMinBy() {
        Comparator<Integer> comparator = Comparator.comparingInt(item -> item * item);
        BinaryOperator<Integer> squareMin =  BinaryOperator.minBy(comparator);
        System.out.println(squareMin.apply(-2, 3));
    }

    public static void testMaxBy() {
        Comparator<Integer> comparator = Comparator.comparingInt(item -> item * item);
        BinaryOperator<Integer> squareMax =  BinaryOperator.maxBy(comparator);
        System.out.println(squareMax.apply(-3, 2));

    }

    public static void main(String[] args) {
//        testApply();
        testMinBy();
        testMaxBy();
    }
}
