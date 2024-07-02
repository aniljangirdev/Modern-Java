package ch3;

import model.Dish;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prog6 {
    public static void main(String[] args) throws IOException {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        int sum = specialMenu
                .stream()
                // we use her mapToInt() instead reduce to avoid boxing
                .mapToInt(Dish::calories)
                .sum();
        System.out.println(sum);

        // to convert primitive to general stream
        Stream<Integer> boxed = specialMenu
                .stream()
                .mapToInt(Dish::calories)
                .boxed();

        int max = specialMenu
                .stream()
                .mapToInt(Dish::calories)
                .max() // here return OptionalInt
                .orElse(0);
        System.out.println(max);

        // numeric range using IntStream, LongStream
        // two methods range()(is exclusive) and rangeClosed()(inclusive),
        long count = IntStream
                // here by using range() we get result 49 instead 50 because is exclusive
                .rangeClosed(1, 100)
                .filter(i -> i % 2 == 0)
                .count();
        System.out.println(count);

        // Stream from value
        Stream<String> stringStream = Stream.of("Modern Java", "Spring boot in AI action");
        stringStream
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //
        Stream<Object> empty = Stream.empty();

        //
        String homeVal = System.getProperty("home");
        Stream<String> homeValStr = Stream.ofNullable(homeVal);

        //
        Stream<String> stringStream1 = Stream.of("Modern Java", "Spring boot in AI action");
        Stream<String> stringStreamVal = stringStream1
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        //
        int[] numbers = {2, 3, 4, 5, 6, 5};
        int sum1 = Arrays.stream(numbers).sum();
        System.out.println(sum1);

        // stream from files
        Path path = Paths.get("src/test.properties");

        try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
            long uniqueWords = lines
                    .flatMap(s -> Arrays.stream(s.split(" ")))
                    .distinct()
                    .count();
            System.out.println(uniqueWords);
        }
    }
}
