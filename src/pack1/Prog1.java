package pack1;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Prog1 {

    public static void main(String[] args) {
        Set<Apple> apples = Set.of();
        Predicate<Apple> appleColorPredicate = (Apple a) -> a.color() == 2;
        Predicate<Apple> appleWeightPredicate = a -> a.weight() > 100;
        List<Apple> apples1 = filterGeneric(apples, appleColorPredicate);
        filterGeneric(apples, appleWeightPredicate);

                // find all transaction by currency
        Currency currency1 = new Currency("DOLER");
        Currency currency2 = new Currency("DINAR");

        Transaction transaction1 = new Transaction(1005, currency1);
        Transaction transaction2 = new Transaction(1002, currency2);

        List<Transaction> transactions = List.of(transaction1, transaction2);
        Map<Currency, List<Transaction>> transactionByCurrency = getTransactionByCurrency1(transactions);
        System.out.println(transactionByCurrency);
    }

    static Map<Currency, List<Transaction>> getTransactionByCurrency1(List<Transaction> transactions){
        return transactions
                .stream()
                .filter(transaction -> transaction.price() > 1000)
                .collect(Collectors.groupingBy(Transaction::currency));
    }
    static Map<Currency, List<Transaction>> getTransactionByCurrency(List<Transaction> transactions){
        Map<Currency, List<Transaction>> transactionsByCurrencies =
                new HashMap<>();
        for (Transaction transaction : transactions) {
            if(transaction.price()> 1000){

                Currency currency = transaction.currency();
                List<Transaction> transactionsForCurrency =
                        transactionsByCurrencies.get(currency);
                if (transactionsForCurrency == null) {
                    transactionsForCurrency = new ArrayList<>();
                    transactionsByCurrencies.put(currency,
                            transactionsForCurrency);
                }
                transactionsForCurrency.add(transaction);
            }
        }
        return transactionsByCurrencies;
    }

    static List<Apple> filter(List<Apple> apples, Predicate<Apple> appleColorPredicate){
        return apples
                .stream()
                .filter(appleColorPredicate)
                .toList();
    }

    //generic
    static <T> List<T> filterGeneric(Collection<T> t, Predicate<T> p){
        return t.stream()
                .filter(p)
                .toList();
    }
}
