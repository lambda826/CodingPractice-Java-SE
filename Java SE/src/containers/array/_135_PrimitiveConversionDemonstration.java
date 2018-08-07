package containers.array;

import java.util.Arrays;

public class _135_PrimitiveConversionDemonstration {
    public static void main(String[] args) {
        Integer[] a = _132_Generated.array(Integer.class, new _128_CountingGenerator.Integer(), 15);
        int[] b = _134_ConvertTo.primitive(a);
        System.out.println(Arrays.toString(b));
        boolean[] c = _134_ConvertTo.primitive(_132_Generated.array(Boolean.class, new _128_CountingGenerator.Boolean(), 7));
        System.out.println(Arrays.toString(c));
    }
}