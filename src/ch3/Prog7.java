package ch3;

import java.util.function.IntSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prog7 {
    public static void main(String[] args) {
        // create infinity stream
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // Fibonacci series
        Stream
                .iterate(new int[]{0, 1},
                        t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);

        // the iterate method takes a predicate as its second argument
        // you can not use filter here for terminate operation
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.err::println);

        IntStream
                .iterate(0, n -> n + 4)
                // you can also use takeWhile() instead secound argument as
                // as above demo in iterate
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);

        // Generate()
        DoubleStream
                .generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //
        IntStream generate = IntStream.generate(() -> 2);

        // print fibo using generate
        IntSupplier fbb = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                previous = current;
                current = nextValue;
                return oldPrevious;
            }
        };
        IntStream
                .generate(fbb)
                .limit(10)
                .forEach(System.out::print);

    }
}
