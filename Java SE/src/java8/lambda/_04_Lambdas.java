package java8.lambda;

import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java8.lambda._01_Behavior_Parameterization.Apple;
import java8.lambda._01_Behavior_Parameterization.Color;

public class _04_Lambdas {

    interface ApplePredicate {
        public boolean test(Apple a);
    }

    static interface DoubleNumberArrayFunc {
        double func(double[] n) throws EmptyArrayException;
    }

    static class EmptyArrayException extends Exception {
        public EmptyArrayException() {
            super("Array Empty");
        }
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public void collections_sort(List<String> words) {

        // Anonymous class instance as a function object - obsolete!
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // Lambda expression as function object (replaces anonymous class)
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        Collections.sort(words, comparingInt(String::length));

        words.sort(comparingInt(String::length));
    }

    public static void main(String... args) {

        // Example 1: () -> void
        Runnable r = () -> System.out.println("Hello!");
        r.run();

        // Example 2: Passing lambda as argument, (Apple) -> boolean
        List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN), new Apple(120, Color.RED));
        System.out.println(filter(inventory, (Apple a) -> Color.GREEN.equals(a.getColor())));

        // Example 3: (T, T) -> int
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        // Example 4: Lambda w/ exception
        double[] values = { 1.0, 2.0 };
        DoubleNumberArrayFunc average = (n) -> {
            double sum = 0;
            if (n.length == 0) {
                throw new EmptyArrayException();
            }
            for (int i = 0; i < n.length; i++) {
                sum += n[i];
            }
            return sum / n.length;
        };

    }

}