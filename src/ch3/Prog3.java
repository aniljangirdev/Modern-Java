package ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prog3 {
    public static void main(String[] args) {
        // problems 1
        String[] strs = new String[]{"Hello", "World"};
        List<String> list = Arrays
                .stream(strs)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
        System.out.println(list);

        // problem 2
        List<String> test = List.of("test", "test2");
        List<String> test2 = List.of("test3", "test4");
        List<List<String>> lists = new ArrayList<>(Arrays.asList(test, test2));
        List<String> toList = lists
                .stream()
                .flatMap(List::stream) // we can avoid boxing to replace from List to Collection
                .toList();
        System.out.println(toList);

        // problem 3
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));
        Integer sumByReduce = integers
                .stream()
                .reduce(0, Integer::sum);
        System.out.println(sumByReduce);

        //problem 4
        List<String> stringList = new ArrayList<>(Arrays.asList("Hello", "World"));
        String strJoin = String.join(" ", stringList);
        System.out.println(strJoin);

        // problem 5 (return squares)
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> list1 = Arrays.stream(nums)
                .map(i -> i * i)
                .toList();

        // problem 6 (return all pairs of numbers?)
        List<Integer> integers1 = List.of(1, 2, 3);
        List<Integer> integers2 = List.of(3, 4);
        List<List<Integer>> collect = integers1
                .stream()
                .flatMap(i -> integers2.stream()
                        .map(j -> new int[]{i, j}))
                // here we convert from int[] an array to List<Integer>
                .map(ints -> Arrays.stream(ints).boxed().collect(Collectors.toList()))
                .toList();
        System.out.println(collect);
    }
}
