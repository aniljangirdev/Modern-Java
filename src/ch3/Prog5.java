package ch3;

import model.Trader;
import model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prog5 {
    public static void main(String[] args) {
        //Here’s the domain you’ll be working with, a list of Traders and Transactions

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

        // Finds all transactions in 2011 and sort by value (small to high)
        List<Transaction> result1 = transactions
                .stream()
                .filter(transaction -> transaction.year() == 2011)
                .sorted(Comparator.comparingInt(Transaction::value))
                .toList();
        System.out.println(result1);

        //what are all the unique cities where the traders work?
        List<String> uniqueCity = transactions
                .stream()
                .map(Transaction::trader)
                .map(Trader::city)
                .distinct()
                .toList();
        System.out.println(uniqueCity);

        //Find all traders from Cambridge and sort them by name.
        List<Trader> allTraderByName = transactions
                .stream()
                .map(Transaction::trader)
                .filter(trader -> trader.city().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::name))
                .toList();
        System.out.println(allTraderByName);

        //Return a string of all traders’ names sorted alphabetically.
        String allTradeName = transactions
                .stream()
                .map(Transaction::trader)
                .map(Trader::name)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
//                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(allTradeName);

        //Are any traders based in Milan?
        boolean flag = transactions
                .stream()
                .anyMatch(transaction -> Objects.equals(transaction.trader().city(), "Milan"));
        System.out.println(flag);

        //Print the values of all transactions from the traders living in Cambridge
        List<Integer> cambridge = transactions
                .stream()
                .filter(transaction -> Objects.equals(transaction.trader().city(), "Cambridge"))
                .map(Transaction::value)
                .toList();
        System.out.println(cambridge);

        //What’s the highest value of all the transactions?
        Integer highest = transactions
                .stream()
                .map(Transaction::value)
                .reduce(Integer::max)
                .orElse(0);
        System.out.println(highest);

        // Find the transaction with the smallest value
        Transaction transaction = transactions
                .stream()
                .min(Comparator.comparingInt(Transaction::value))
                .orElse(null);
        System.out.println(transaction);
    }
}
