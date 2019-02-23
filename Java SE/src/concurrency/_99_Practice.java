/**
 *  @author Yunxiang He
 *  @date   02/22/2019
 */

package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _99_Practice implements Runnable {
    class ExtendThread extends Thread { @Override public void run() { } }
    class ImplementRunnable implements Runnable { @Override public void run() { } }
    class ImplementCallable implements Callable<String> { @Override public String call() { return null; } }
    ThreadLocal<String> value = new ThreadLocal<String>() { @Override public String initialValue() { return "1"; } };
    public void test() {
        ExtendThread t1 = new ExtendThread();
        Thread run = new Thread(new ImplementRunnable());
        t1.start();
        run.start();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(t1);
        exec.execute(run);
        Future<String> future = exec.submit(new ImplementCallable());
        try {String String = future.get();} catch (Exception e) {}
        value.set("1");
        value.get();
    }
    
    public static void main(String[] args) {
        _99_Practice shared = new _99_Practice();
        _99_Practice shared2 = new _99_Practice();
        Thread t1 = new Thread(shared);
        Thread t2 = new Thread(shared);
        t1.start();
        t2.start();
    }

      long i = 0;
    @Override
    public  void run() {
        while (i  < 1000100) {
            synchronized (_99_Practice.class) {
                
            }
            i++;
            i++;
            if ((i & 1) == 1) {
                System.out.println(11);
            }
        }
    }
}
