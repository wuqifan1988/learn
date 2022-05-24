package com.example.learn.java8.shizhan.Ch04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        List<Transaction> tradersIn2011 = transactions.stream().filter(transaction -> transaction.getYear() == 2011).
            sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(tradersIn2011);

        List<String> citys = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());
        System.out.println(citys);

        List<Trader> cambridgeTraders = transactions.stream().map(Transaction::getTrader).distinct().
            filter(trader -> trader.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName))
            .collect(Collectors.toList());
        System.out.println(cambridgeTraders);

        List<String> traderNames = transactions.stream().map(Transaction::getTrader).distinct().map(Trader::getName)
            .collect(Collectors.toList());
        System.out.println(traderNames);

        Boolean hasMilanTrader = transactions.stream().map(Transaction::getTrader).distinct()
            .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println(hasMilanTrader);

        int cambridgeSum = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue).
            reduce(0, Integer::sum);
        System.out.println(cambridgeSum);

        transactions.stream().map(Transaction::getValue).max(
            Comparator.comparingInt(Integer::intValue)
        ).ifPresent(System.out::println);

        transactions.stream().min(Comparator.comparingInt(Transaction::getValue)).ifPresent(System.out::println);

    }

}
