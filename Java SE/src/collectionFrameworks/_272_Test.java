package collectionFrameworks;
// Framework for performing timed tests of containers.

public abstract class _272_Test<C> {
    String name;

    public _272_Test(String name) {
        this.name = name;
    }

    // Override this method for different tests.
    // Returns actual number of repetitions of test.
    abstract int test(C container, _273_TestParam tp);
}