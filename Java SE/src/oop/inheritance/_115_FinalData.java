package oop.inheritance;

import static utils.Print.print;

import java.util.Random;

class Value {
    int i;

    public Value(int i) {
        this.i = i;
    }
}

public class _115_FinalData {
    private static Random rand = new Random(47);
    private String id;

    public _115_FinalData(String id) {
        this.id = id;
    }

    // Can be compile-time constants:
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    // Typical public constant:
    public static final int VALUE_THREE = 39;
    // Cannot be compile-time constants:
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    // Arrays:
    private final int[] a = { 1, 2, 3, 4, 5, 6 };

    public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }

    public static void main(String[] args) {
        _115_FinalData fd1 = new _115_FinalData("fd1");
        // Error: can't change value
        //! fd1.valueOne++; 
        // Object isn't constant!
        fd1.v2.i++;
        // OK -- not final
        fd1.v1 = new Value(9);
        for (int i = 0; i < fd1.a.length; i++) {
            // Object isn't constant!
            fd1.a[i]++;
        }

        // Error: Can't
        //! fd1.v2 = new Value(0); 
        // change reference
        //! fd1.VAL_3 = new Value(1); 
        //! fd1.a = new int[3];
        print(fd1);
        print("Creating new FinalData");
        _115_FinalData fd2 = new _115_FinalData("fd2");
        print(fd1);
        print(fd2);
    }
}