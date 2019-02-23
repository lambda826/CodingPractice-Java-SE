package concurrency;

// {RunByHand}
import java.util.concurrent.locks.*;

public class _30_MutexEvenGenerator extends _26_IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield(); // Cause failure faster
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        _27_EvenChecker.test(new _30_MutexEvenGenerator());
        String i2 = "2";
        String i1 = new String("2");
        i1.intern();
        System.out.println(i1 == i2);
    }
}
