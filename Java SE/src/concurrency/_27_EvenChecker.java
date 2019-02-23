package concurrency;

import java.util.concurrent.*;

public class _27_EvenChecker implements Runnable {
    
    private _26_IntGenerator generator;
    private final int id;

    public _27_EvenChecker(_26_IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel(); // Cancels all EvenCheckers
            }
        }
    }

    // Test any type of IntGenerator:
    public static void test(_26_IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new _27_EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    // Default value for count:
    public static void test(_26_IntGenerator gp) {
        test(gp, 10);
    }
}
