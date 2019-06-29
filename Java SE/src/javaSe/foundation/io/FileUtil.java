package javaSe.foundation.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    public static Path createIfAbsent(final String directory) {
        Path dir = Paths.get(directory);
        if (!Files.exists(dir)) {
            try {
                dir = Files.createDirectories(dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dir;
    }

    public static Path createIfAbsent(final String directory, final String fileName) {
        createIfAbsent(directory);
        Path file = Paths.get(directory, fileName);
        if (!Files.exists(file)) {
            try {
                file = Files.createFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
