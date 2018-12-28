package stream;

import static java.util.stream.Collectors.toList;
import static stream._00_Dish.menu;

import java.util.Arrays;
import java.util.List;

public class _02_Operations {

    public static void main(String... args) {

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Filtering
        System.out.println("----- Filtering -----");
        menu.stream().filter(_00_Dish::isVegetarian).collect(toList()).forEach(System.out::println);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Distinct
        System.out.println("----- Distinct -----");
        Arrays.asList(1, 2, 1, 3, 3, 2, 4).stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Truncating
        System.out.println("----- Truncating -----");
        menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList()).forEach(System.out::println);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Skipping
        System.out.println("----- Skipping -----");
        menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList()).forEach(System.out::println);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Slicing JDK 9+
        List<_00_Dish> specialMenu = Arrays.asList(new _00_Dish("season fruit", true, 120, _00_Dish.Type.OTHER), new _00_Dish("prawns", false, 300, _00_Dish.Type.FISH), new _00_Dish("rice", true, 350, _00_Dish.Type.OTHER),
                new _00_Dish("chicken", false, 400, _00_Dish.Type.MEAT), new _00_Dish("french fries", true, 530, _00_Dish.Type.OTHER));
        System.out.println("Filtered sorted menu:");
        List<_00_Dish> filteredMenu = specialMenu.stream().filter(dish -> dish.getCalories() < 320).collect(toList());
        filteredMenu.forEach(System.out::println);
        // takeWhile
        //        System.out.println("Sorted menu sliced with takeWhile():");
        //        List<Dish> slicedMenu1 = specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320).collect(toList());
        //        slicedMenu1.forEach(System.out::println);
        //
        // dropWhile
        //        System.out.println("Sorted menu sliced with dropWhile():");
        //        List<Dish> slicedMenu2 = specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(toList());
        //        slicedMenu2.forEach(System.out::println);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // map
        System.out.println("----- Map -----");
        menu.stream().map(_00_Dish::getName).collect(toList()).forEach(System.out::println);
        System.out.println();

        Arrays.asList("Modern", "Java", "In", "Action").stream().map(String::length).forEach(System.out::println);
        System.out.println();

        menu.stream().map(_00_Dish::getName).map(String::length).forEach(System.out::println);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // flatMap
        System.out.println("----- FlatMap -----");
        Arrays.asList("Hello", "World").stream().flatMap((String line) -> Arrays.stream(line.split(""))).distinct().forEach(System.out::println);
        System.out.println();

        Arrays.asList("Hello", "World").stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
        System.out.println();

        Arrays.asList(1, 2, 3, 4, 5).stream().flatMap((Integer i) -> Arrays.asList(6, 7, 8).stream().map((Integer j) -> new int[] { i, j })).filter(pair -> (pair[0] + pair[1]) % 3 == 0).collect(toList())
                .forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
        System.out.println();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Matching
        System.out.println("----- Matching -----");
        System.out.println(menu.stream().anyMatch(_00_Dish::isVegetarian));
        System.out.println(menu.stream().allMatch(d -> d.getCalories() < 1000));
        System.out.println(menu.stream().noneMatch(d -> d.getCalories() >= 1000));

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Finding
        System.out.println("----- Finding -----");
        menu.stream().filter(_00_Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().map(n -> n * n).filter(n -> n % 3 == 0).findFirst().get());
        System.out.println();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Reducing
        System.out.println("----- Reducing -----");
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        System.out.println(numbers.stream().reduce(0, (a, b) -> a + b));
        System.out.println(numbers.stream().reduce(0, Integer::sum));
        System.out.println(numbers.stream().reduce(0, (a, b) -> Integer.max(a, b)));
        numbers.stream().reduce(Integer::min).ifPresent(System.out::println);
        System.out.println("Number of calories:" + menu.stream().map(_00_Dish::getCalories).reduce(0, Integer::sum));
        System.out.println(menu.stream().count());
        System.out.println();
    }

}
