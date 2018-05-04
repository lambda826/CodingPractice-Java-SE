package collections.holding;

import java.util.*;

import generics._02_GenericInterfaces.Generator;

public class _238_CollectionData<T> extends ArrayList<T> {
    public _238_CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++)
            add(gen.next());
    }

    public static <T> _238_CollectionData<T> list(Generator<T> gen, int quantity) {
        return new _238_CollectionData<T>(gen, quantity);
    }
}