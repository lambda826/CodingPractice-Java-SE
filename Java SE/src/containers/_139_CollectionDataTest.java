package containers;

import java.util.LinkedHashSet;
import java.util.Set;

import generics._02_GenericInterfaces.Generator;

class Government implements Generator<String> {
    String[] foundation = ("strange women lying in ponds distributing swords is no basis for a system of government").split(" ");
    private int index;

    public String next() {
        return foundation[index++];
    }
}

public class _139_CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(new _138_CollectionData<String>(new Government(), 15));
        // Using the convenience method:
        set.addAll(_138_CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}