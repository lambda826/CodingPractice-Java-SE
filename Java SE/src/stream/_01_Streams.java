package stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }

    @Override
    public String toString() {
        return name + " ";
    }

    public static final Map<String, List<String>> dishTags = new HashMap<>();

    static {
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));
    }

    public static final List<Dish> menu = asList(new Dish("pork", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 400, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

    public String setName(String name) {
        return name;
    }
}

public class _01_Streams {

    public static void main(String... args) {

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Basic
        System.out.println("Low Caloric Dishes Name\n--------------------------------");
        Dish.menu.stream().filter(dish -> dish.getCalories() < 400).sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(toList()).forEach(System.out::println);
        System.out.println();

        System.out.println("Three High Caloric Dish Names\n--------------------------------");
        Dish.menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(toList()).forEach(System.out::println);
        System.out.println();

        // A stream can be traversed only once
        Stream<String> s = Arrays.asList("Modern", "Java", "In", "Action").stream();
        // java.lang.IllegalStateException: stream has already been operated upon or closed
        // s.forEach(System.out::println);
        s.forEach(System.out::println);
        System.out.println();

        // Intermediate operations can usually be merged and processed into a single pass by the terminal operation
        // Laziness1
        Dish.menu.stream().filter(dish -> {
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
