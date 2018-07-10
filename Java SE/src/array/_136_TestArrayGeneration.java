package array;

import static common.utils.Print.print;

import java.util.Arrays;

public class _136_TestArrayGeneration {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = _134_ConvertTo.primitive(_132_Generated.array(Boolean.class, new _130_RandomGenerator.Boolean(), size));
        print("a1 = " + Arrays.toString(a1));
        byte[] a2 = _134_ConvertTo.primitive(_132_Generated.array(Byte.class, new _130_RandomGenerator.Byte(), size));
        print("a2 = " + Arrays.toString(a2));
        char[] a3 = _134_ConvertTo.primitive(_132_Generated.array(Character.class, new _130_RandomGenerator.Character(), size));
        print("a3 = " + Arrays.toString(a3));
        short[] a4 = _134_ConvertTo.primitive(_132_Generated.array(Short.class, new _130_RandomGenerator.Short(), size));
        print("a4 = " + Arrays.toString(a4));
        int[] a5 = _134_ConvertTo.primitive(_132_Generated.array(Integer.class, new _130_RandomGenerator.Integer(), size));
        print("a5 = " + Arrays.toString(a5));
        long[] a6 = _134_ConvertTo.primitive(_132_Generated.array(Long.class, new _130_RandomGenerator.Long(), size));
        print("a6 = " + Arrays.toString(a6));
        float[] a7 = _134_ConvertTo.primitive(_132_Generated.array(Float.class, new _130_RandomGenerator.Float(), size));
        print("a7 = " + Arrays.toString(a7));
        double[] a8 = _134_ConvertTo.primitive(_132_Generated.array(Double.class, new _130_RandomGenerator.Double(), size));
        print("a8 = " + Arrays.toString(a8));
    }
}