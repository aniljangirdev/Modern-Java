package ch2;

import java.util.function.Function;

public class Prog5 {
    public static void main(String[] args) {
        // composite function
        Function<Integer, Integer> function = i -> i + 2;
        Function<Integer, Integer> function1 = i -> i * 2;
        Function<Integer, Integer> function2 = function.andThen(function1);
        Integer apply = function2.apply(2);
        System.out.println(apply);

        Function<Integer, Integer> compose = function.compose(function1);
        Integer apply1 = compose.apply(2);
        System.out.println(apply1);

    }
}
