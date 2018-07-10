//: initialization/ArrayInit.java
// Array initialization.
package array;

import java.util.*;

public class _104_ArrayInit {
    public static void main(String[] args) {
        // In both cases, the final comma in the list of initializers is optional
        // Autoboxing
        Integer[] a = { new Integer(1), new Integer(2), 3, };
        // Autoboxing
        Integer[] b = new Integer[] { new Integer(1), new Integer(2), 3, };
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}