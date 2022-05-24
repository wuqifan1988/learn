package com.example.learn.java8.shizhan.Ch02;

import java.util.Arrays;
import java.util.List;

public class Test2_1 {

    public static void prettyPrintApple(List<Apple> inventory, AppleFormat appleFormat) {
        for (Apple apple : inventory) {
            String output = appleFormat.accept(apple);
            System.out.println(output);
        }
    }





    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(Apple.builder().weight(100).color("red").build(),
                Apple.builder().weight(200).color("green").build());
        prettyPrintApple(apples,new AppleSimpleFormat());
    }
}


interface AppleFormat {
    String accept(Apple a);
}

class AppleSimpleFormat implements AppleFormat {

    @Override
    public String accept(Apple a) {
        return String.format("An apple of %sg", a.getWeight());
    }
}