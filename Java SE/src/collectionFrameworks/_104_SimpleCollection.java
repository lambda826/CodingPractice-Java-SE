package collectionFrameworks;

import java.util.*;

public class _104_SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            // Autoboxing
            c.add(i);
        }
        for (Integer i : c) {
            System.out.print(i + ", ");
        }
    }
}