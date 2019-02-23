package concurrency;

import java.util.concurrent.*;

public class _06_FixedThreadPool {
    public static void main(String[] args) {
        // Constructor argument is number of threads:
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new _01_LiftOff());
        }
        exec.shutdown();
    }
} 