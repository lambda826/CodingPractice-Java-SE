package concurrency;

public class _28_EvenGenerator extends _26_IntGenerator {
    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue; // Danger point here!
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        _27_EvenChecker.test(new _28_EvenGenerator());
    }
}