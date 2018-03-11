package collections.holding;

import java.util.*;

public class _234_MultiIterableClass extends _230_IterableClass {
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public String next() {
                        return words[current--];
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<String> randomized() {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<String>(Arrays.asList(words));

                // Collections.shuffle() method doesn’t affect the original array, but only shuffles the references in shuffled
                // This is only true because the randomized() method wraps an ArrayList around the result of Arrays.asList()
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        _234_MultiIterableClass mic = new _234_MultiIterableClass();
        for (String s : mic.reversed())
            System.out.print(s + " ");
        System.out.println();
        for (String s : mic.randomized())
            System.out.print(s + " ");
        System.out.println();
        for (String s : mic)
            System.out.print(s + " ");
    }
}