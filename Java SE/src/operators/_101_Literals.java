package operators;

import static utils.Print.print;

public class _101_Literals {
    public static void main(String[] args) {
        int i1 = 0x2f;
        int i2 = 0X2F;
        int i3 = 0177;
        char c = 0xffff;
        byte b = 0x7f;
        short s = 0x7fff;
        long n1 = 200L;
        long n2 = 200l;
        long n3 = 200;
        float f1 = 1;
        float f2 = 1F;
        float f3 = 1f;
        double d1 = 1d;
        double d2 = 1D;
        double e = Math.E;
        print(e);
    }
}