package stream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static stream._00_Dish.menu;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class _07_Reducting_Summarizing {

    public static void main(String... args) {

        System.out.println("Nr. of dishes: " + menu.stream().collect(counting()));

        System.out.println("Short menu: " + menu.stream().map(_00_Dish::getName).collect(joining()));
        System.out.println("Short menu comma separated: " + menu.stream().map(_00_Dish::getName).collect(joining(", ")));

        System.out.println("Total calories in menu: " + menu.stream().collect(reducing(0, _00_Dish::getCalories, (Integer i, Integer j) -> i + j)));
        System.out.println("Total calories in menu: " + menu.stream().collect(reducing(0, _00_Dish::getCalories, Integer::sum)));
        System.out.println("Total calories in menu: " + menu.stream().map(_00_Dish::getCalories).reduce(Integer::sum).get());
        System.out.println("Total calories in menu: " + menu.stream().mapToInt(_00_Dish::getCalories).sum());

        System.out.println("The most caloric dish is: " + menu.stream().collect(maxBy(Comparator.comparingInt(_00_Dish::getCalories))).get());
        
        System.out.println("Total calories in menu: " + menu.stream().collect(summingInt(_00_Dish::getCalories)));
        System.out.println("Average calories in menu: " + menu.stream().collect(averagingInt(_00_Dish::getCalories)));
        System.out.println("Menu statistics: " + menu.stream().collect(summarizingInt(_00_Dish::getCalories)));

        System.out.println("The most caloric dish is: " + menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get());
        System.out.println("The most caloric dish is: " + menu.stream().collect(reducing(BinaryOperator.maxBy(Comparator.comparingInt(_00_Dish::getCalories)))).get());

    }

}
