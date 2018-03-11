package collections.holding;

import java.util.*;

/*
 * A foreach statement works with an array or anything Iterable, but that doesn’t mean that an array is automatically an Iterable, nor is there any autoboxing that takes place
 */
public class _232_ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib)
            System.out.print(t + " ");
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = { "A", "B", "C" };
        // An array works in foreach, but it's not Iterable:
        //! test(strings);
        // You must explicitly convert it to an Iterable:
        test(Arrays.asList(strings));
    }
}