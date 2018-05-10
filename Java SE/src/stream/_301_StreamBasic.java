package stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _301_StreamBasic {

    public static void main(String... args) {
        // Java 7
        getLowCaloricDishesNamesInJava7(_300_Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(_300_Dish.menu).forEach(System.out::println);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<_300_Dish> dishes) {
        List<_300_Dish> lowCaloricDishes = new ArrayList<>();
        for (_300_Dish d : dishes) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<_300_Dish>() {
            public int compare(_300_Dish d1, _300_Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for (_300_Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<_300_Dish> dishes) {
        return dishes.stream().filter(d -> d.getCalories() < 400).sorted(comparing(_300_Dish::getCalories)).map(_300_Dish::getName).collect(toList());
        //        return dishes.parallelStream().filter(d -> d.getCalories() < 400).sorted(comparing(_300_Dish::getCalories)).map(_300_Dish::getName).collect(toList());
    }
}
