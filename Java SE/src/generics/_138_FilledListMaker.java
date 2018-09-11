package generics;

import java.util.*;

public class _138_FilledListMaker<T> {
    List<T> create(T t, int n) {
        List<T> result = new ArrayList<T>();
        // Even though the compiler is unable to know anything about T inside create(), it can still ensure—at compile time—that what you put into result is of type T, so that it agrees with ArrayList<T>.
        // Thus, even though erasure removes the information about the actual type inside a method or class, the compiler can still ensure internal consistency in the way that the type is used within the method or class.
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        _138_FilledListMaker<String> stringMaker = new _138_FilledListMaker<String>();
        List<String> list = stringMaker.create("Hello", 4);
        System.out.println(list);
    }
}