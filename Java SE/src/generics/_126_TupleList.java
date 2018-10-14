package generics;

import java.util.ArrayList;

public class _126_TupleList<A, B, C, D> extends ArrayList<_104_FourTuple<A, B, C, D>> {

    public static void main(String[] args) {
        _126_TupleList<Vehicle, Amphibian, String, Integer> tl = new _126_TupleList<Vehicle, Amphibian, String, Integer>();
        tl.add(_106_TupleTest.h());
        tl.add(_106_TupleTest.h());
        for (_104_FourTuple<Vehicle, Amphibian, String, Integer> i : tl) {
            System.out.println(i);
        }
    }
}