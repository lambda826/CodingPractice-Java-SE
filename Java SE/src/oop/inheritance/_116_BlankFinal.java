package oop.inheritance;

class Poppet {

    private int i;

    Poppet(int ii) {
        i = ii;
    }

}

public class _116_BlankFinal {
    private final int i = 0;
    // Blank final
    private final int j;
    // Blank final reference
    private final Poppet p;

    // Blank finals MUST be initialized in the constructor:
    public _116_BlankFinal() {
        // Initialize blank final
        j = 1;
        // Initialize blank final reference
        p = new Poppet(1);
    }

    public _116_BlankFinal(int x) {
        // Initialize blank final
        j = x;
        // Initialize blank final reference
        p = new Poppet(x);
    }

    public static void main(String[] args) {
        new _116_BlankFinal();
        new _116_BlankFinal(47);
    }
}
