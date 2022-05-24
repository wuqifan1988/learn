package com.example.learn.java8.shizhan.Ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squareList = list.stream().map(item -> item * item).collect(Collectors.toList());
        System.out.println(squareList);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<int[]> resultList = list1.stream().flatMap(i ->
                {
                    Stream<int[]> stream = list2.stream().filter(j -> (i+j)%3==0).map(j -> new int[]{i, j});
                    System.out.println(stream);
                    return stream;
                }
        )
                .collect(Collectors.toList());
        resultList.forEach(item -> {
            System.out.println(item[0] + "," + item[1]);
        });
    }
}
