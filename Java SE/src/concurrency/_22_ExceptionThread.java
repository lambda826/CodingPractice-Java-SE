package concurrency;

// {ThrowsException}
import java.util.concurrent.*;

public class _22_ExceptionThread implements Runnable {
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new _22_ExceptionThread());
    }
} ///:~
