package java8.lambda;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import java8.lambda._01_Behavior_Parameterization.Apple;
import java8.lambda._01_Behavior_Parameterization.Color;

public class _08_Sorting_Step_By_Step {

    static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }

    public static void main(String... args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN), new Apple(120, Color.RED)));

        // 1 Pass code
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        // 2 Anonymous class
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        // 3 Lambda expression
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);

        // 4 Method reference
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);

    }

}
