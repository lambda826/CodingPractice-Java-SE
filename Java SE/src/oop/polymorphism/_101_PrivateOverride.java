package oop.polymorphism;

import static utils.Print.*;

public class _101_PrivateOverride {

    // a private method is automatically final,
    private void f() {
        print("private f()");
    }

    public static void main(String[] args) {
        _101_PrivateOverride po = new Derived();
        po.f();
    }

}

class Derived extends _101_PrivateOverride {

    public void f() {
        print("public f()");
    }

}