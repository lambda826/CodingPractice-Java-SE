package javaSe.java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _03_Execute_Around_Pattern {

    static String path = "D:/01__Development/Coding Practice/Java SE/Java SE/src/lambda/data.txt";

    // Method we want to refactor to make more flexible
    public static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    // BufferedReader -> String
    @FunctionalInterface
    public interface BufferedReaderProcessor {
        public String process(BufferedReader b) throws IOException;

    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return p.process(br);
        }
    }

    public static void main(String... args) throws IOException {

        // Limited behavior
        System.out.println(processFileLimited());

        // Passing lambda expression as behaviors
        System.out.println(processFile((BufferedReader b) -> b.readLine()));
        System.out.println(processFile((BufferedReader b) -> b.readLine() + b.readLine()));

    }

}
