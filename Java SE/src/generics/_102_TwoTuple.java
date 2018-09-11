package generics;

// One of the things you often want to do is return multiple objects from a method call. 
// The return statement only allows you to specify a single object
// so the answer is to create an object that holds the multiple objects that you want to return.
public class _102_TwoTuple<A, B> {

    // The final declaration buys you the same safety
    public final A first;
    public final B second;

    public _102_TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
