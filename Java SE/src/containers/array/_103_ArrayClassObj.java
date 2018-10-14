//: initialization/ArrayClassObj.java
// Creating an array of nonprimitive objects.
package containers.array;

import static utils.Print.*;

import java.util.*;

public class _103_ArrayClassObj {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] a = new Integer[rand.nextInt(20)];
        print("length of a = " + a.length);
        for (int i = 0; i < a.length; i++) {
            // Autoboxing
            a[i] = rand.nextInt(500);
        }
        print(Arrays.toString(a));
    }
}