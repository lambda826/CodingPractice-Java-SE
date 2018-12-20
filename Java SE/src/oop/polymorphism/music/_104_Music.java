package oop.polymorphism.music;

public class _104_Music {

    public static void tune(_102_Instrument i) {
        i.play(_101_Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        _103_Wind flute = new _103_Wind();
        tune(flute);

        _102_Instrument flute2 = new _103_Wind();
        tune(flute2);

        _102_Instrument flute3 = new _102_Instrument();
        tune(flute3);
    }

}