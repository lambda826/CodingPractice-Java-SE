package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lambda._01_Behavior_Parameterization.Apple;
import lambda._01_Behavior_Parameterization.Color;

public class _04_Lambdas {

    interface ApplePredicate {
        public boolean test(Apple a);
    }

    public static void main(String... args) {

        // Simple example
        Runnable r = () -> System.out.println("Hello!");
        r.run();

        // Filtering with lambdas
        List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN), new Apple(120, Color.RED));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]	
        List<Apple> greenApples = filter(inventory, (Apple a) -> Color.GREEN.equals(a.getColor()));
        System.out.println(greenApples);

        Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        inventory.sort(c);
        System.out.println(inventory);
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

}