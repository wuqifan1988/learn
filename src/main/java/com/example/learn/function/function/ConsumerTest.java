package com.example.learn.function.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author xiuce
 * @version 1.0
 * @date 2021/12/29 4:29 下午
 * 一个参数，无返回值的函数
 * @see java.util.function.Consumer
 * @see BiConsumerTest
 */
public class ConsumerTest {

    Consumer<String> printStr = System.out::println;

    Consumer<String> printWithLineSpliter = item -> {
        Arrays.stream(item.split(",")).forEach(System.out::println);
    };

    @Test
    public void test(){
        printStr.accept("123456");
    }

    @Test
    public void testAndThen() {
        printStr.andThen(printWithLineSpliter).accept("123,223,323");
    }
}
