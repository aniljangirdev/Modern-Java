package ch2;

import model.Apple;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

public class Prog4 {
    public void main(String[] args) {
        /*
        Predicate<T interface defines an abstract method named
        test that accepts an object of generic type T and return boolean
        eg. filter()
        **/
        Predicate<String> stringPredicate = String::isEmpty;
        Predicate<Apple> applePredicate = apple -> apple.getWeight().isEmpty();
        // intPredicate, longpredicate, doubleredicate to avoid boxing
        /*
        Consumer<T> interface defined an abstract method named accept(T) that
        take object of generic type T and returns no result(Void)
        eg. forEach()
        **/
        Consumer<String> stringConsumer = System.out::println;
//        IntConsumer, DoubleConsumer, LongConsumer to avoid boxing

        // example of supplier
        final String greeting = "Welcome";
        Runnable runnable = () -> System.out.println(greeting);
        Supplier<Apple> appleSupplier = Apple::new;
        BiFunction<String, Integer, String> biFunction = String::substring;
        Function<String, Integer> integerFunction = Integer::parseInt;
        Function<String, String> stringStringFunction = String::toUpperCase;


        ToIntFunction<String> toIntFunction = String::length;
        IntBinaryOperator intBinaryOperator = Integer::sum;
        BiFunction<Apple, Apple, Integer> appleAppleIntegerBiFunction = (Apple a, Apple b) -> a.getWeight().compareTo(b.getWeight());
        ToIntBiFunction<Apple, Apple> appleAppleToIntBiFunction = (Apple a, Apple b) -> a.getWeight().compareTo(b.getWeight());

        UnaryOperator<String> stringUnaryOperator = String::toString;

        Callable<Integer> callable = () -> 42;

        /*
        // supplier
        * */

        /*
        Function<T, R> interface defined an abstract method apply that take object of type T as input
        and return object if Type.
        eg. map()
        **/
        ToIntBiFunction<String, String> stringStringToIntBiFunction = String::compareToIgnoreCase;
        Predicate<String> stringBooleanFunction = this::isValidName;
        BiPredicate<List<String>, String> listStringBiPredicate = List::contains;

        TriFunction<Integer, Integer, Integer, String> function = (integer, integer2, s) -> "Welcome";
    }

    private boolean isValidName(String name) {
        return Character.isUpperCase(name.charAt(0));
    }

    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, R r);
    }
}
