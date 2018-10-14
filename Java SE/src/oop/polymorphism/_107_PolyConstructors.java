package oop.polymorphism;

import static utils.Print.*;

class Glyph {
    void draw() {
        print("Glyph.draw()");
    }

    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

/*
1. The storage allocated for the object is initialized to binary zero before anything else happens.
2. The base-class constructors are called as described previously. At this point, the overridden draw( ) method is called (yes, before the RoundGlyph constructor is called), which discovers a radius value of zero, due to Step 1.
3. Member initializers are called in the order of declaration.
4. The body of the derived-class constructor is called.
*/
class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

public class _107_PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}