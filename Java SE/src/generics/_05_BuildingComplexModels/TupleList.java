package generics._05_BuildingComplexModels;


import java.util.ArrayList;

import generics._01_SimpleGenerics.TupleTest;
import generics._01_SimpleGenerics.classes.Amphibian;
import generics._01_SimpleGenerics.classes.Vehicle;
import generics._01_SimpleGenerics.tuple.FourTuple;

public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<Vehicle, Amphibian, String, Integer>();
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        for (FourTuple<Vehicle, Amphibian, String, Integer> i : tl)
            System.out.println(i);
    }
}