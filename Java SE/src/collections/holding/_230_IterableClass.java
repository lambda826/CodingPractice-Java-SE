package collections.holding;

import java.util.*;

/*
 * If you create any class that implements Iterable, you can use it in a foreach statement
 */
public class _230_IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " + "we know the Earth to be banana-shaped.").split(" ");

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            public boolean hasNext() {
                return index < words.length;
            }

            public String next() {
                return words[index++];
            }

            public void remove() {
                // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new _230_IterableClass())
            System.out.print(s + " ");
    }
}