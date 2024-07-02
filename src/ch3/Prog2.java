package ch3;

import model.Dish;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Prog2 {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));


        List<Dish> list = specialMenu
                .stream()
                // here we can use takeWhile() instead filter for better performance
                // as per above data list already sorted by calories, and we no need to filtering to
                // all dishes, thats why use takeWhile, and this will impect when large number of dataset.
                .takeWhile(dish -> dish.calories() < 320)
                .toList();

        specialMenu
                .stream()
                .filter(dish -> dish.calories() < 300)
                .skip(2)
                .toList();

        List<String> list1 = specialMenu
                .stream()
                .map(Dish::name)
                .toList();

        list1
                .stream()
                .mapToInt(String::length)
                .boxed()
                .toList();
    }

}
