package ch4;

import ch1.Currency;
import ch1.Transaction;

import java.util.List;

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

        // Partition a list of transactions into two groups: expensive and not expensive
        // (returning a Map<Boolean, List<Transaction>>)

        // Create multilevel groupings, such as grouping transactions by cities and then
        //further categorizing by whether they’re expensive or not (returning a Map<String,
        //Map<Boolean, List<Transaction>>>)
    }
}
