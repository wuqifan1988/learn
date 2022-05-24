package com.example.learn.testng;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Listeners(MyAlterSuiteListener.class)
public class MyTestNg {

    public static void test(Object obj) {
        List<String> list = (List) obj;
        System.out.println(list);
        for (Object o: list
             ) {
            System.out.println(o instanceof String);
        }

    }

    public static void main(String[] args) {
//        List<Integer> set = new ArrayList<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//
//         test(set.stream().map(String::valueOf).collect(Collectors.toList()));


         Map<String,String> map1 = new HashMap<String,String>() {{
             put("1","111");
             put("2","222");
             put("3","333");
         }};

         Map<String,String> map2 = new HashMap<String ,String >() {{

             put("2","222");
             put("3","333");
             put("4","444");
         }};

         Map<String,String> combine = Stream.concat(map1.entrySet().stream(),map2.entrySet().stream())
                 .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (before, after) -> after));
        System.out.println(combine);

    }
}
