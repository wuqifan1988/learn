package com.example.learn.java8.shizhan.Ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        // 获得3个卡路里大于300的菜品名称
        List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 300)
                .map(Dish::getName).limit(3).collect(Collectors.toList());

        // 输出荤菜
        List<Dish> huncai = menu.stream().filter(dish -> !dish.isVegetarian())
                .limit(2).collect(Collectors.toList());

        // 输入一个单词表，输出列表里各不相同的字母
        List<String> words = Arrays.asList("Hello", "World");
        String[] arraysOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arraysOfWords);

//        System.out.println(words.stream().map(word -> word.split("")).distinct().collect(Collectors.toList()));
//        System.out.println(words.stream().map(word -> word.split("")).map(Arrays::stream).distinct().collect(Collectors.toList()));
        List<String> uniqueCharacters = words.stream().map(word -> word.split("")).
                flatMap(Arrays::stream).distinct().collect(Collectors.toList());
//        System.out.println(uniqueCharacters);

        System.out.println(menu.stream().map(dish -> 1).reduce(0, Integer::sum));

    }
}
