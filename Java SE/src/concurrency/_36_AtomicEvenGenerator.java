package concurrency;

// Atomic classes are occasionally useful in regular code.
// {RunByHand}
import java.util.concurrent.atomic.*;

public class _36_AtomicEvenGenerator extends _26_IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        _27_EvenChecker.test(new _36_AtomicEvenGenerator());
    }
} ///:~
