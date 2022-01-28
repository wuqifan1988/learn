package com.example.learn.jdk.collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author xiuce
 * @version 1.0
 * @date 2022/1/11 11:51 上午
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        arrayList.forEach(System.out::println);


    }
}

class MyArray implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }
}

class MyIterator implements Iterator<Integer> {

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return 1;
    }
}
