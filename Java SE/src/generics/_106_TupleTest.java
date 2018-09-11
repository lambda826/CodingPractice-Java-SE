package generics;

class Amphibian {

}

class Vehicle {

}

public class _106_TupleTest {

    public static _102_TwoTuple<String, Integer> f() {
        return new _102_TwoTuple<String, Integer>("hi", 47);
    }

    public static _103_ThreeTuple<Amphibian, String, Integer> g() {
        return new _103_ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
    }

    public static _104_FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new _104_FourTuple<Vehicle, Amphibian, String, Integer>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    public static _105_FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new _105_FiveTuple<Vehicle, Amphibian, String, Integer, Double>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        _102_TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        // Compile error: final
        // ttsi.first = "there"; 
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}