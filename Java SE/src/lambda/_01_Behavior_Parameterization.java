package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _01_Behavior_Parameterization<T> {

    static enum Color {
        RED, GREEN
    }

    public static class Fruit {

    }

    public static class Orange extends Fruit {
        public Orange(int weight) {
        }
    }

    public static class Apple extends Fruit {
        private int weight = 0;
        private Color color;

        public Apple() {
        }

        public Apple(int weight) {
            this.weight = weight;
        }

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Ugly approaches
    // Filter green apples, before Java 8
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // The only different line
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // However, if the farmer wants multiple colors
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // The only different line
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    // The farmer wants to filter the apple by weights
    public static List<Apple> filterHeavyApples(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // The only different line
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    // Filter every attribute
    public static List<Apple> filterHeavyApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // The only different line
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Behavior Parameterization
    static interface ApplePredicate {
        boolean test(Apple apple);
    }

    // Strategy #1
    static class AppleWeightPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    // Strategy #2
    static class AppleColorPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return Color.GREEN.equals(apple.getColor());
        }
    }

    // Strategy #3
    static class AppleRedAndHeavyPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }

    // Filtering by abstract criteria
    public static List<Apple> filter(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    // Abstracting over List type
    interface Predicate<T> {
        boolean test(T t);
    }

    public List<T> filter2(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    // Practice
    public interface AppleFormatter {
        String accept(Apple a);
    }

    public class AppleFancyFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            return "A " + (apple.getWeight() > 150 ? "heavy" : "light") + " " + apple.getColor() + " apple";
        }
    }

    public class AppleSimpleFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN), new Apple(120, Color.RED));

        System.out.println(filterApplesByColor(inventory, Color.GREEN));
        System.out.println(filterApplesByColor(inventory, Color.RED));
        System.out.println(filter(inventory, new AppleColorPredicate()));
        System.out.println(filter(inventory, new AppleWeightPredicate()));
        System.out.println(filter(inventory, new AppleRedAndHeavyPredicate()));

        // Anonymous class
        System.out.println(filter(inventory, new ApplePredicate() {
            public boolean test(Apple apple) {
                return apple.getColor().equals(Color.RED);
            }
        }));

        // Lambda expression
        System.out.println(filter(inventory, (Apple apple) -> apple.getColor().equals(Color.RED)));

        // Generic type
        _01_Behavior_Parameterization<Integer> instance = new _01_Behavior_Parameterization<>();
        System.out.println(instance.filter2(Arrays.asList(new Integer[] { 1, 3, 6, 8 }), (Integer i) -> i % 2 == 0));

        // Sorting with a comparator
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight() - a2.getWeight();
            }
        });
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight());

        // Executing a block of code with Runnable
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello world");
            }
        });
        t = new Thread(() -> System.out.println("Hello world"));
        t.run();

        // Returing a result using Callable
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
        threadName = executorService.submit(() -> Thread.currentThread().getName());
        try {
            threadName.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
