package generics._09_Wildcards;

import java.util.*;

public class GenericWriting {

    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();

    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

}
