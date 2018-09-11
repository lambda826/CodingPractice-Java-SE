package generics;

import java.lang.reflect.*;
import java.util.*;

public class _136_ArrayMaker<T> {
    private Class<T> kind;

    public _136_ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        // Even though kind is stored as Class<T>, erasure means that it is actually just being stored as a Class, with no parameter. 
        // So, when you do something with it, as in creating an array, Array.newInstance() doesn’t actually have the type information that’s implied in kind; 
        // so it cannot produce the specific result, which must therefore be cast, which produces a warning that you cannot satisfy.
        // Array.newInstance() is the recommended approach for creating arrays in generics.
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        _136_ArrayMaker<String> stringMaker = new _136_ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}