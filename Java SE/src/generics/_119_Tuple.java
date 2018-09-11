package generics;

public class _119_Tuple {

    public static <A, B> _102_TwoTuple<A, B> tuple(A a, B b) {
        return new _102_TwoTuple<A, B>(a, b);
    }

    public static <A, B, C> _103_ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new _103_ThreeTuple<A, B, C>(a, b, c);
    }

    public static <A, B, C, D> _104_FourTuple<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new _104_FourTuple<A, B, C, D>(a, b, c, d);
    }

    public static <A, B, C, D, E> _105_FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new _105_FiveTuple<A, B, C, D, E>(a, b, c, d, e);
    }
}
