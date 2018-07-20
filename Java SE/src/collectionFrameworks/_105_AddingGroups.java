package collectionFrameworks;

import java.util.*;

public class _105_AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = { 6, 7, 8, 9, 10 };
        // The Collection.addAll( ) member method can only take an argument of another Collection object
        collection.addAll(Arrays.asList(moreInts));
        // Runs significantly faster, but you can't construct a Collection this way:
        // Arrays.asList( ) or Collections.addAll( ), which use variable argument lists
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        // OK -- modify an element
        list.set(1, 99);
        // Runtime error because the underlying array cannot be resized.
        // list.add(21);
    }
}