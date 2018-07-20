package array;

import collectionFrameworks._238_CollectionData;
import generics._02_GenericInterfaces.Generator;

public class _132_Generated {
    // Fill an existing array:
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new _238_CollectionData<T>(gen, a.length).toArray(a);
    }

    // Create a new array:
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
        return new _238_CollectionData<T>(gen, size).toArray(a);
    }
}