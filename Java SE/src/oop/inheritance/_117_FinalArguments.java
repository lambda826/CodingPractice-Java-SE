package oop.inheritance;

class Gizmo {

    public void spin() {
    }

}

public class _117_FinalArguments {

    void with(final Gizmo g) {
        // Illegal -- g is final
        //! g = new Gizmo();
    }

    void without(Gizmo g) {
        g = new Gizmo();
        g.spin();
    }

    // You can only read from a final primitive:
    int g(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        _117_FinalArguments bf = new _117_FinalArguments();
        bf.without(null);
        bf.with(null);
    }

}