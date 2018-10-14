package oop.inheritance;

import static utils.Print.*;

class Insect {

    private int i = 9;
    protected int j;

    Insect() {
        print("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        print(s);
        return 47;
    }

}

public class _120_Beetle extends Insect {

    private int k = printInit("Beetle.k initialized");

    public _120_Beetle() {
        print("k = " + k);
        print("j = " + j);
    }

    private static int x2 = printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        print("Beetle constructor");
        _120_Beetle b = new _120_Beetle();
    }

}