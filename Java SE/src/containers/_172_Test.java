package containers;
// Framework for performing timed tests of containers.

public abstract class _172_Test<C> {
    String name;

    public _172_Test(String name) {
        this.name = name;
    }

    // Override this method for different tests.
    // Returns actual number of repetitions of test.
    abstract int test(C container, _173_TestParam tp);
}