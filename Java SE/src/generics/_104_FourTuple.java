package generics;

public class _104_FourTuple<A, B, C, D> extends _103_ThreeTuple<A, B, C> {

    public final D fourth;

    public _104_FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
    }
}