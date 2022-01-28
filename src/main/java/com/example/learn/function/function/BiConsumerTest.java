package com.example.learn.function.function;

import java.util.function.BiConsumer;

/**
 * @author xiuce
 * @version 1.0
 * @date 2021/12/29 3:20 下午
 * BiConsumer 一个有两个参数和不返回值的函数
 */
public class BiConsumerTest {

    static BiConsumer<String,String> print2words = (str1,str2) -> System.out.println(str1 + ":" + str2);
    static BiConsumer<String,String> print2wordsCommon = (str1,str2) -> System.out.println(str1 + "," + str2);

    /**
     * params: 执行函数
     */
    public static void testAccept(){
        print2words.accept("第一个","第二个");
    }

    /**
     * andThen: 先执行自己，再执行andThen传递的函数
     *
     * 参数：
     * after： 下一个执行的函数
     * 返回值：
     * 一个按顺序执行的复合函数，先执行当前函数，再执行after函数
     */
    public static void testAndThen() {
        print2words.andThen(print2wordsCommon).accept("第一个","第二个");
    }

    public static void main(String[] args) {
        testAccept();
        testAndThen();
    }

}
