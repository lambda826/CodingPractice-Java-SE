package array;

import java.util.ArrayList;
import java.util.List;

import common.obj.BerylliumSphere;

public class _125_ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // It is possible to create arrays of generics.
        List<String>[] ls = new List[10];
        // List<String>[] ls = new List<String>[10];
        // "Unchecked" warning
        List[] la = new List[10];
        ls = (List<String>[]) la;
        ls[0] = new ArrayList<String>();
        // Compile-time checking produces an error:
        //! ls[1] = new ArrayList<Integer>();

        // The problem: List<String> is a subtype of Object
        // So assignment is OK
        Object[] objects = ls;
        // Compiles and runs without complaint:
        objects[1] = new ArrayList<Integer>();

        // However, if your needs are straightforward it is possible to create an array of generics, albeit with an "unchecked" warning:
        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<BerylliumSphere>();
        }
    }
}
