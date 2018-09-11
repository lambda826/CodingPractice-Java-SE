package generics;

public class _103_ThreeTuple<A, B, C> extends _102_TwoTuple<A, B> {

    public final C third;

    public _103_ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}
