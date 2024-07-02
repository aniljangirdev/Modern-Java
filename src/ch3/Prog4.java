package ch3;

import model.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Prog4 {
    public static void main(String[] args) {
        // findALl, findAny, noneMatch, findFirst, allMatch

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        specialMenu
                .stream()
                .anyMatch(Dish::vegetarian);

        specialMenu
                .stream()
                .allMatch(dish -> dish.calories() < 1000);

        specialMenu
                .stream()
                .noneMatch(dish -> dish.calories() >= 1000);

        specialMenu
                .stream()
                .filter(Dish::vegetarian)
                .findFirst()
                .orElse(null);

        //Calculate the sum of all calories in the menu
        int totalCalories = specialMenu
                .stream()
                .map(Dish::calories)
                .reduce(0, Integer::sum);
        System.out.println(totalCalories);

        //What is the highest calorie dish in the menu?
        Dish dish = specialMenu
                .stream()
                .max(Comparator.comparingInt(Dish::calories))
                .orElse(null);
        System.out.println(dish);

        // find minimum
        Dish dish2  = specialMenu
                .stream()
                .min(Comparator.comparingInt(Dish::calories))
                .orElse(null);
        System.out.println(dish2);

        Integer minCalori = specialMenu
                .stream()
                .map(Dish::calories)
//                .reduce((n1, n2) -> n1 < n2 ? n1 : n2)
                .reduce(Integer::min)
                .orElse(0);

        System.out.println(minCalori);
    }
}
