package java8.stream;

import static java.util.stream.Collectors.toList;
import static java8.stream.pojo.Dish.menu;
import static java8.stream.pojo.Dish.specialMenu;

import java.util.Arrays;
import java.util.List;

import java8.stream.pojo.Dish;

public class _02_Operations {

    public static void main(String... args) {

        // Filtering
        menu.stream().filter(Dish::isVegetarian).collect(toList()).forEach(System.out::println);

        // Distinct
        Arrays.asList(1, 2, 1, 3, 3, 2, 4).stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        // Limiting
        menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList()).forEach(System.out::println);

        // Skipping
        menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList()).forEach(System.out::println);

        // Mapping
        menu.stream().map(Dish::getName).collect(toList()).forEach(System.out::println);
        Arrays.asList("Modern", "Java", "In", "Action").stream().map(String::length).forEach(System.out::println);
        menu.stream().map(Dish::getName).map(String::length).forEach(System.out::println);

        // FlatMapping
        Arrays.asList("Hello", "World").stream().flatMap((String line) -> Arrays.stream(line.split(""))).distinct().forEach(System.out::println);
        Arrays.asList("Hello", "World").stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
        Arrays.asList(1, 2, 3, 4, 5).stream().flatMap((Integer i) -> Arrays.asList(6, 7, 8).stream().map((Integer j) -> new int[] { i, j })).filter(pair -> (pair[0] + pair[1]) % 3 == 0).collect(toList())
                .forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));

        // Matching
        menu.stream().anyMatch(Dish::isVegetarian);
        menu.stream().allMatch(d -> d.getCalories() < 1000);
        menu.stream().noneMatch(d -> d.getCalories() >= 1000);

        // Finding
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().map(n -> n * n).filter(n -> n % 3 == 0).findFirst().get());

        // Reducing
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        numbers.stream().reduce(0, (a, b) -> a + b);
        numbers.stream().reduce(0, Integer::sum);
        numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        numbers.stream().reduce(Integer::min).ifPresent(System.out::println); // No intial value, return Optional<T>
        menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        menu.stream().count();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Slicing JDK 9+
        // TakeWhile
        specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320).collect(toList());
        // DropWhile
        specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(toList());
    }

}
