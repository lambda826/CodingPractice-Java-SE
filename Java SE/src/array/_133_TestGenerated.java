package array;

import java.util.Arrays;

public class _133_TestGenerated {
    public static void main(String[] args) {
        Integer[] a = { 9, 8, 7, 6 };
        System.out.println(Arrays.toString(a));
        a = _132_Generated.array(a, new _128_CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));
        Integer[] b = _132_Generated.array(Integer.class, new _128_CountingGenerator.Integer(), 15);
        System.out.println(Arrays.toString(b));
    }
}