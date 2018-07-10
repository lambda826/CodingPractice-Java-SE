package array;

import java.util.Arrays;

import common.obj.BerylliumSphere;

public class _120_MultidimensionalObjectArrays {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = { { new BerylliumSphere(), new BerylliumSphere() }, { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() }, { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() }, };
        System.out.println(Arrays.deepToString(spheres));
    }
}