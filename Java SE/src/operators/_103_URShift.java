package operators;

import static utils.Print.*;

public class _103_URShift {
    public static void main(String[] args) {
        int i = -1;
        print(Integer.toBinaryString(i));
        i >>>= 10;
        print(Integer.toBinaryString(i));
        long l = -1;
        print(Long.toBinaryString(l));
        l >>>= 10;
        print(Long.toBinaryString(l));
        // There is a problem, however, with the unsigned right shift combined with assignment. 
        // If you use it with byte or short, you don’t get the correct results. 
        // Instead, these are promoted to int and right shifted, but then truncated as they are assigned back into their variables, so you get -1 in those cases
        short s = -1;
        print(Integer.toBinaryString(s));
        s >>>= 20;
        print(Integer.toBinaryString(s));
        byte b = -1;
        print(Integer.toBinaryString(b));
        b >>>= 10;
        print(Integer.toBinaryString(b));
        b = -1;
        print(Integer.toBinaryString(b));
        print(Integer.toBinaryString(b >>> 10));
    }
}