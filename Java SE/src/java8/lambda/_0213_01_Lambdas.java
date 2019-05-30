package java8.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparingInt;

public class _0213_01_Lambdas {

    public void collections_sort(List<String> words) {

        // Anonymous class instance as a function object - obsolete!
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // Lambda expression as function object (replaces anonymous class)
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        Collections.sort(words, comparingInt(String::length));

        words.sort(comparingInt(String::length));
    }
}
