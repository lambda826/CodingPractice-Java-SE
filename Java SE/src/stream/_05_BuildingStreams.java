package stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _05_BuildingStreams {

    public static void main(String... args) {

        // Stream.of
        Stream.of("Java 8", "Lambdas", "In", "Action").map(String::toUpperCase).forEach(System.out::println);

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        // Arrays.stream
        System.out.println(Arrays.stream(new int[] { 2, 3, 5, 7, 11, 13 }).sum());

        // Files.lines
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("There are " + uniqueWords + " unique words in data.txt");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Streams from functions (infinite stream)
        // Stream.iterate
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        // fibonnaci with iterate
        System.out.println("----- fibonnaci with iterate -----");
        Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
        System.out.println();
        Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).map(t -> t[0]).forEach(System.out::println);
        System.out.println();
        
        // Stream.generate
        // random stream of doubles with Stream.generate
        System.out.println("----- random stream of doubles with Stream.generate -----");
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        System.out.println();

        // stream of 1s with Stream.generate
        System.out.println("----- stream of 1s with Stream.generate -----");
        IntStream.generate(() -> 1).limit(5).forEach((n) ->System.out.print(n + " "));
        System.out.println();

        IntStream.generate(new IntSupplier() {
            public int getAsInt() {
                return 2;
            }
        }).limit(5).forEach((n) ->System.out.print(n + " "));
        System.out.println();
        
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        IntStream.generate(fib).limit(10).forEach((n) ->System.out.print(n + " "));
    }
}
