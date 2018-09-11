package generics._07_ArraysOfGenerics;

import java.util.*;

/*
 * You can’t create arrays of generics. 
 * The general solution is to usean ArrayList everywhere that you are tempted to create an array of generics:
 */
public class _146_ListOfGenerics<T> {
    private List<T> array = new ArrayList<T>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}