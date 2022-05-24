package com.example.learn.java8.shizhan.Ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<Apple> filterApples(List<Apple> apples, ApplePredict applePredict) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: apples) {
            if(applePredict.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(Apple.builder().weight(100).color("red").build(),
                Apple.builder().weight(200).color("green").build());

        apples = filterApples(apples, new ApplePredict() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        System.out.println(apples);





    }
}
