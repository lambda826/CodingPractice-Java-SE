package oop.polymorphism.music;

import static utils.Print.print;

class Instrument {

    void play(_101_Note n) {
        print("Instrument.play() " + n);
    }

    String what() {
        return "Instrument";
    }

    void adjust() {
        print("Adjusting Instrument");
    }
}

class Wind extends Instrument {

    void play(_101_Note n) {
        print("Wind.play() " + n);
    }

    String what() {
        return "Wind";
    }

    void adjust() {
        print("Adjusting Wind");
    }
}

class Percussion extends Instrument {

    void play(_101_Note n) {
        print("Percussion.play() " + n);
    }

    String what() {
        return "Percussion";
    }

    void adjust() {
        print("Adjusting Percussion");
    }
}

class Stringed extends Instrument {

    void play(_101_Note n) {
        print("Stringed.play() " + n);
    }

    String what() {
        return "Stringed";
    }

    void adjust() {
        print("Adjusting Stringed");
    }
}

class Brass extends Wind {

    void play(_101_Note n) {
        print("Brass.play() " + n);
    }

    void adjust() {
        print("Adjusting Brass");
    }
}

class Woodwind extends Wind {

    void play(_101_Note n) {
        print("Woodwind.play() " + n);
    }

    String what() {
        return "Woodwind";
    }
}

public class _108_Music3 {

    // Doesn't care about type, so new types added to the system still work right:
    public static void tune(Instrument i) {
        i.play(_101_Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = { new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind() };
        tuneAll(orchestra);

        Instrument i = new Woodwind();
        i.adjust();
    }
}