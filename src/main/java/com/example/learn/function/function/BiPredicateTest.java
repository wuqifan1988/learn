package com.example.learn.function.function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.BiPredicate;

/**
 * @author xiuce
 * @version 1.0
 * @date 2021/12/29 4:02 下午
 * 传递两个参数，返回boolean
 */
public class BiPredicateTest {

    public static BiPredicate<Integer, Integer> isBigger = (item1, item2) -> item1 - item2 > 0;
    static BiPredicate<Integer, Integer> isSquareBigger = (item1, item2) -> item1*item1 - item2*item2 > 0;

    /**
     * 执行函数
     */
    @Test
    public void testTest() {
        Assertions.assertFalse(isBigger.test(2, 3));
        Assertions.assertTrue(isBigger.test(3, 2));
    }

    @Test
    public void testAnd() {
        Assertions.assertTrue(isBigger.and(isSquareBigger).test(3, 2));
        Assertions.assertFalse(isBigger.and(isSquareBigger).test(3, -4));
    }

    @Test
    public void testOr() {
        Assertions.assertTrue(isBigger.or(isSquareBigger).test(-4,3));
        Assertions.assertTrue(isBigger.or(isSquareBigger).test(4,-5));
        Assertions.assertFalse(isBigger.or(isSquareBigger).test(4,5));
        Assertions.assertTrue(isBigger.or(isSquareBigger).test(4,3));
    }

    /**
     * 取反
     */
    @Test
    public void testNegate(){
        Assertions.assertFalse(isBigger.negate().test(3,2));
        Assertions.assertTrue(isBigger.negate().test(2,3));
    }

}
