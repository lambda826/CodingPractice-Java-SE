package stream;

import static stream.Dish.menu;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class _04_NumericStreams {

    public static void main(String... args) {

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Number of calories:" + menu.stream().mapToInt(Dish::getCalories).sum());
        menu.stream().mapToInt(Dish::getCalories).boxed();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // max and OptionalInt
        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
        int max;
        if (maxCalories.isPresent()) {
            max = maxCalories.getAsInt();
        } else {
            // we can choose a default value
            max = 1;
        }
        System.out.println(max);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // numeric ranges
        System.out.println(IntStream.range(0, 100).filter(n -> n % 2 == 0).count());
        System.out.println(IntStream.rangeClosed(0, 100).filter(n -> n % 2 == 0).count());

        IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed().map(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }))
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
        IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) }).filter(t -> t[2] % 1 == 0))
                .map(array -> Arrays.stream(array).mapToInt(a -> (int) a).toArray()).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    public static boolean isPerfectSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

}
