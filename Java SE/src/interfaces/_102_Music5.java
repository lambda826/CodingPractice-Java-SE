//: interfaces/music5/Music5.java
// Interfaces.
package interfaces;

import static utils.Print.print;

import oop.polymorphism.music._101_Note;

interface InstrumentInterface {
    // Compile-time constant:
    // static & final
    int VALUE = 5;

    // Cannot have method definitions:
    // Automatically public
    void play(_101_Note n);

    void adjust();
}

class WindImpl implements InstrumentInterface {

    public void play(_101_Note n) {
        print(this + ".play() " + n);
    }

    public String toString() {
        return "Wind";
    }

    public void adjust() {
        print(this + ".adjust()");
    }
}

class PercussionImpl implements InstrumentInterface {

    public void play(_101_Note n) {
        print(this + ".play() " + n);
    }

    public String toString() {
        return "Percussion";
    }

    public void adjust() {
        print(this + ".adjust()");
    }

}

class StringedImpl implements InstrumentInterface {

    public void play(_101_Note n) {
        print(this + ".play() " + n);
    }

    public String toString() {
        return "Stringed";
    }

    public void adjust() {
        print(this + ".adjust()");
    }

}

class BrassImpl extends WindImpl {

    public String toString() {
        return "Brass";
    }

}

class WoodwindImpl extends WindImpl {

    public String toString() {
        return "Woodwind";
    }

}

public class _102_Music5 {

    // Doesn't care about type, so new types dded to the system still work right:
    static void tune(InstrumentInterface i) {
        i.play(_101_Note.MIDDLE_C);
    }

    static void tuneAll(InstrumentInterface[] e) {
        for (InstrumentInterface i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        InstrumentInterface[] orchestra = { new WindImpl(), new PercussionImpl(), new StringedImpl(), new BrassImpl(), new WoodwindImpl() };
        tuneAll(orchestra);
    }
}