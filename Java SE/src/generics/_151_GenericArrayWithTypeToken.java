package generics;

import java.lang.reflect.*;

public class _151_GenericArrayWithTypeToken<T> {
    
    private T[] array;

    // The type token Class<T> is passed into the constructor in order to recover from the erasure, so that we can create the actual type of array that we need, 
    @SuppressWarnings("unchecked")
    public _151_GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Expose the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        _151_GenericArrayWithTypeToken<Integer> gai = new _151_GenericArrayWithTypeToken<Integer>(Integer.class, 10);
        // This now works:
        Integer[] ia = gai.rep();
    }
}