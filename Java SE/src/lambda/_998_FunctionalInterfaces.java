/**
 *  @author: Yunxiang He
 *  @date  : 2018-05-02 08:45
 */

package lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class _998_FunctionalInterfaces {

    // Predicate
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    // Consumer
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }

    // Handle exception
    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

    // Function
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("");
        listOfStrings.add(" ");
        listOfStrings.add("a");

        // Predicate test
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(Arrays.toString(nonEmpty.toArray()));

        // Predicate test
        forEach(Arrays.asList(1, 2, 3, 4, 5, 6), (Integer i) -> System.out.println(i));

        // Function test
        List<Integer> list = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        System.out.println(Arrays.toString(list.toArray()));

        // Handle exception test
        BufferedReaderProcessor p = (BufferedReader br) -> br.readLine();

        Function<BufferedReader, String> f = (BufferedReader b) -> {
            try {
                return b.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort(String::compareToIgnoreCase);

    }

}
