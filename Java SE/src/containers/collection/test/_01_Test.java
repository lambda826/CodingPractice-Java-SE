package containers.collection.test;

public abstract class _01_Test<C> {
    String name;

    public _01_Test(String name) {
        this.name = name;
    }

    // Override this method for different tests.
    // Returns actual number of repetitions of test.
    abstract int test(C container, _02_TestParam tp);
}