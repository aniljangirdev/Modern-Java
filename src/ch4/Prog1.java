package ch4;

import ch1.Currency;
import ch1.Transaction;
import model.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class Prog1 {
    public static void main(String[] args) {
        // find all transaction by currency
        Currency currency1 = new Currency("DOLER");
        Currency currency2 = new Currency("DINAR");

        Transaction transaction1 = new Transaction(1005, currency1);
        Transaction transaction2 = new Transaction(1002, currency2);

        List<Transaction> transactions = List.of(transaction1, transaction2);

        //Group a list of transactions by currency to obtain the sum of the values of all
        //transactions with that currency (returning a Map<Currency, Integer>)
        transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::currency));

        // Partition a list of transactions into two groups: expensive and not expensive
        // (returning a Map<Boolean, List<Transaction>>)

        // Create multilevel groupings, such as grouping transactions by cities and then
        //further categorizing by whether they’re expensive or not (returning a Map<String,
        //Map<Boolean, List<Transaction>>>)

        long count = transactions
                .stream()
                .count();

        Optional<Transaction> max = transactions
                .stream()
                .max(Comparator.comparing(Transaction::price));

        Double collect = transactions
                .stream()
                .collect(Collectors.summingDouble(Transaction::price));

        Double collect1 = transactions
                .stream()
                .collect(Collectors.averagingDouble(Transaction::price));

        DoubleSummaryStatistics collect2 = transactions
                .stream()
                .collect(Collectors.summarizingDouble(Transaction::price));
        System.out.println(collect2);


        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        String collect3 = specialMenu
                .stream()
                .map(Dish::name)
                .collect(Collectors.joining(", "));
        System.out.println(collect3);

        Integer totalCalories = specialMenu
                .stream()
                .map(Dish::calories)
                .reduce(0, Integer::sum);

        Map<Dish.Type, List<Dish>> collect4 = specialMenu
                .stream()
                .collect(Collectors.groupingBy(Dish::type));

        Map<Dish.Type, List<Dish>> collect5 = specialMenu
                .stream()
                .collect(Collectors.groupingBy(Dish::type,
                        Collectors.filtering(dish -> dish.calories() > 500, Collectors.toList())));




    }
}
