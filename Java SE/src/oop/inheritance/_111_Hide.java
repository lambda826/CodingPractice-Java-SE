package oop.inheritance;

import static utils.Print.*;

class Homer {

    char doh(char c) {
        print("doh(char)");
        return 'd';
    }

    float doh(float f) {
        print("doh(float)");
        return 1.0f;
    }

}

class Milhouse {
}

class Bart extends Homer {

    // If a Java base class has a method name that’s overloaded several times, redefining that method name in the derived class will not hide any of the base-class versions
    void doh(Milhouse m) {
        print("doh(Milhouse)");
    }

}

public class _111_Hide {

    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }

}

class _112_Lisa extends Homer {

    // @Override
    void doh(Milhouse m) {
        System.out.println("doh(Milhouse)");
    }

}