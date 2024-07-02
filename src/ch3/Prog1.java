package ch3;

import model.Dish;

import java.util.*;

public class Prog1 {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        List<Dish> lowCaloriesDish = new ArrayList<>();
        // traditional aprooch
        for (Dish dish : menu) {
            if (dish.calories() < 400) {
                lowCaloriesDish.add(dish);
            }
        }

        Collections.sort(menu, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.calories(), o2.calories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish caloriesDish : lowCaloriesDish) {
            lowCaloricDishesName.add(caloriesDish.name());
        }

        // using streamAPI

        List<String> list = menu
                .stream()
                .filter(dish -> dish.calories() < 400)
                .sorted(Comparator.comparingInt(Dish::calories))
                .distinct()
                .limit(2)
                .map(Dish::name)
                .toList();

        System.out.println(list);


    }

}
