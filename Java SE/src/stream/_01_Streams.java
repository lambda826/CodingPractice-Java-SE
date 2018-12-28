package stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.stream.Stream;

public class _01_Streams {

    public static void main(String... args) {

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Basic
        System.out.println("Low Caloric Dishes Name\n--------------------------------");
        _00_Dish.menu.stream().filter(dish -> dish.getCalories() < 400).sorted(comparing(_00_Dish::getCalories)).map(_00_Dish::getName).collect(toList()).forEach(System.out::println);
        System.out.println();

        System.out.println("Three High Caloric Dish Names\n--------------------------------");
        _00_Dish.menu.stream().filter(dish -> dish.getCalories() > 300).map(_00_Dish::getName).limit(3).collect(toList()).forEach(System.out::println);
        System.out.println();

        // A stream can be traversed only once
        Stream<String> s = Arrays.asList("Modern", "Java", "In", "Action").stream();
        // java.lang.IllegalStateException: stream has already been operated upon or closed
        // s.forEach(System.out::println);
        s.forEach(System.out::println);
        System.out.println();

        // Intermediate operations can usually be merged and processed into a single pass by the terminal operation
        // Laziness1
        _00_Dish.menu.stream().filter(dish -> {
            System.out.println("filtering:" + dish.getName());
            return dish.getCalories() > 300;
        }).map(dish -> {
            System.out.println("mapping:" + dish.getName());
            return dish.getName();
        }).limit(3).collect(toList());
        System.out.println();

        // Laziness2
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).stream().filter(n -> {
            System.out.println("filtering " + n);
            return n % 2 == 0;
        }).map(n -> {
            System.out.println("mapping " + n);
            return n * n;
        }).limit(2).collect(toList()).forEach(System.out::println);

    }

}
