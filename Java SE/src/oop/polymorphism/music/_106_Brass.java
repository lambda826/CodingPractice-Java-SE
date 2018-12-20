package oop.polymorphism.music;

import static utils.Print.print;

public class _106_Brass extends _102_Instrument {

    public void play(_101_Note n) {
        print("Brass.play() " + n);
    }

}
