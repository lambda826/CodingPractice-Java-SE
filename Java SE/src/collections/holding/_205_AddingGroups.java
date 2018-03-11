package collections.holding;

// Adding groups of elements to Collection objects.
import java.util.*;

public class _205_AddingGroups {
    public static void main(String[] args) {
        // Arrays.asList() takes either an array or a commaseparated list of elements (using varargs) and turns it into a List object
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = { 6, 7, 8, 9, 10 };
        collection.addAll(Arrays.asList(moreInts));

        // Runs significantly faster, but you can't construct a Collection this way:
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        // Produces a list "backed by" an array:
        // It’s also possible to use the output of Arrays.asList() directly, as a List, but the underlying representation in this case is the array, which cannot be resized
        // If you try to add() or delete() elements in such a list, that would attempt to change the size of an array, so you’ll get an "Unsupported Operation" error at run time.
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);

        // OK -- modify an element
        list.set(1, 99);

        // Runtime error because the underlying array cannot be resized.
        list.add(21);
    }
}
