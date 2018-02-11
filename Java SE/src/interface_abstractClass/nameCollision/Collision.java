/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 9:46:33 PM
 */

package interface_abstractClass.nameCollision;

interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {
    public void f() {
    }

    // overloaded
    public int f(int i) {
        return 1;
    }
}

class C3 extends C implements I2 {
    // overloaded
    public int f(int i) {
        return 1;
    }
}

class C4 extends C implements I3 {
    // Identical, no problem:
    public int f() {
        return 1;
    }
}