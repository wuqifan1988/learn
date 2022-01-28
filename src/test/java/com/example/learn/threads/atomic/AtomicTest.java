package com.example.learn.threads.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiuce
 * @version 1.0
 * @date 2021/12/24 11:40 上午
 */
public class AtomicTest {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for(int i=0;i<1000000;i++){
                count.getAndIncrement();
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i=0;i<1000000;i++){
                count.getAndIncrement();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(count);
    }
}
