package clazz;

import static utils.Print.*;

class Mug {
    Mug(int marker) {
        print("Mug(" + marker + ")");
    }

    void f(int marker) {
        print("f(" + marker + ")");
    }
}

public class _105_Mugs {
    Mug mug1;
    Mug mug2;
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        print("mug1 & mug2 initialized");
    }

    _105_Mugs() {
        print("Mugs()");
    }

    _105_Mugs(int i) {
        print("Mugs(int)");
    }

    public static void main(String[] args) {
        print("Inside main()");
        new _105_Mugs();
        print("new Mugs() completed");
        new _105_Mugs(1);
        print("new Mugs(1) completed");
    }
}