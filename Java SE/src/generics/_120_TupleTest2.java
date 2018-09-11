package generics;

import static generics._119_Tuple.tuple;

public class _120_TupleTest2 {
    
    static _102_TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static _102_TwoTuple f2() {
        return tuple("hi", 47);
    }

    static _103_ThreeTuple<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static _104_FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static _105_FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        _102_TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}