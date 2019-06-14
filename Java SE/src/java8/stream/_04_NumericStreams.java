package java8.stream;

import static java8.stream.pojo.Dish.menu;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import java8.stream.pojo.Dish;

public class _04_NumericStreams {

    public static void main(String... args) {

        // IntStream
        menu.stream().mapToInt(Dish::getCalories).sum();
        menu.stream().mapToInt(Dish::getCalories).boxed();

        // Max and OptionalInt
        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
        maxCalories.orElse(1);
        maxCalories.getAsInt();
        
        // Numeric ranges
        IntStream.range(0, 2).filter(n -> n % 2 == 0).count();
        IntStream.rangeClosed(0, 2).filter(n -> n % 2 == 0).count();

        // Pythagorean triples
        IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed().map(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }))
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
        IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) }).filter(t -> t[2] % 1 == 0))
                .map(array -> Arrays.stream(array).mapToInt(a -> (int) a).toArray()).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    public static boolean isPerfectSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

}
