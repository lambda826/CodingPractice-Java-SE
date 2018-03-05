package generics._01_SimpleGenerics;

import generics._01_SimpleGenerics.classes.Amphibian;
import generics._01_SimpleGenerics.classes.Vehicle;
import generics._01_SimpleGenerics.tuple.FiveTuple;
import generics._01_SimpleGenerics.tuple.FourTuple;
import generics._01_SimpleGenerics.tuple.ThreeTuple;
import generics._01_SimpleGenerics.tuple.TwoTuple;

public class TupleTest {
    public static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("hi", 47);
    }

    public static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
    }

    public static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<Vehicle, Amphibian, String, Integer>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    public static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        // Compile error: final
        // ttsi.first = "there"; 
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}