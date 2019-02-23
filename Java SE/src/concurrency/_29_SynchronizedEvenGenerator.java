package concurrency;

public class _29_SynchronizedEvenGenerator extends _26_IntGenerator {
    private int currentEvenValue = 0;

    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        _27_EvenChecker.test(new _29_SynchronizedEvenGenerator());
    }
}
