package com.example.learn.java8.shizhan.Ch04;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

}
