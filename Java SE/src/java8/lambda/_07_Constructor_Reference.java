package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import java8.lambda.pojos.Apple;
import java8.lambda.pojos.Color;
import java8.lambda.pojos.Fruit;
import java8.lambda.pojos.Orange;

public class _07_Constructor_Reference {

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static void main(String[] args) {
        Apple apple;
        Supplier<Apple> s = Apple::new;
        s = () -> new Apple();
        apple = s.get();

        Function<Integer, Apple> f = Apple::new;
        f = (weight) -> new Apple(weight);
        apple = f.apply(100);

        // Passing a constructor reference to the map method
        List<Integer> weights = Arrays.asList(7, 3, 5, 10);
        List<Apple> apples = map(weights, Apple::new);

        BiFunction<Integer, Color, Apple> biF = Apple::new;
        biF = (weight, color) -> new Apple(weight, color);
        apple = biF.apply(100, Color.GREEN);

        Fruit fruit = giveMeApple("apple", 100);

    }

    public static Fruit giveMeApple(String fruit, Integer weight) {
        return map.get(fruit.toLowerCase()).apply(weight);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }
        return result;
    }
}
