package generics._03_GenericMethods;

import static generics._01_SimpleGenerics.tuple.Tuple.tuple;
import generics._01_SimpleGenerics.classes.Amphibian;
import generics._01_SimpleGenerics.classes.Vehicle;
import generics._01_SimpleGenerics.tuple.FiveTuple;
import generics._01_SimpleGenerics.tuple.FourTuple;
import generics._01_SimpleGenerics.tuple.ThreeTuple;
import generics._01_SimpleGenerics.tuple.TwoTuple;

public class TupleTest2 {
    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static TwoTuple f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}