package generics;

class Manipulator<T> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    // Error: cannot find symbol: method f():
    //    public void manipulate() {
    //        obj.f();
    //    }
}

public class _131_Manipulation {
    public static void main(String[] args) {
        _130_HasF hf = new _130_HasF();
        Manipulator<_130_HasF> manipulator = new Manipulator<_130_HasF>(hf);
        //        manipulator.manipulate();
    }
}