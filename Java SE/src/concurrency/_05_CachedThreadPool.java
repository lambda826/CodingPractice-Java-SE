package concurrency;

import java.util.concurrent.*;

public class _05_CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new _01_LiftOff());
        }
        exec.shutdown();
    }
} 