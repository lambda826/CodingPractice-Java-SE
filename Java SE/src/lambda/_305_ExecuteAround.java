package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _305_ExecuteAround {

    static String path = "src/lambda/data.txt";

    public static void main(String... args) throws IOException {

        // Method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

        String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);

    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return p.process(br);
        }
    }

    public interface BufferedReaderProcessor {
        public String process(BufferedReader b) throws IOException;

    }
}
