package generics._01_SimpleGenerics.tuple;

public class TwoTuple<A, B> {

    // The final declaration buys you the same safety, but the above form is shorter and simpler
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
