package com.example.learn.function.function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

/**
 * @author xiuce
 * @version 1.0
 * @date 2021/12/29 4:27 下午
 * 无参返回boolean的函数
 */
public class BooleanSupplierTest {

    static BooleanSupplier isTrue = () -> true;

    @Test
    public void test(){
        Assertions.assertTrue(isTrue.getAsBoolean());
    }
}
