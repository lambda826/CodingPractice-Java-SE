package generics;

public class _105_FiveTuple<A, B, C, D, E> extends _104_FourTuple<A, B, C, D> {

    public final E fifth;

    public _105_FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fifth = e;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ")";
    }
}
