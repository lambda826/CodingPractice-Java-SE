package containers.array;

import containers._138_CollectionData;
import generics._109_Generator;

public class _132_Generated {
    // Fill an existing array:
    public static <T> T[] array(T[] a, _109_Generator<T> gen) {
        return new _138_CollectionData<T>(gen, a.length).toArray(a);
    }

    // Create a new array:
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, _109_Generator<T> gen, int size) {
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
        return new _138_CollectionData<T>(gen, size).toArray(a);
    }
}