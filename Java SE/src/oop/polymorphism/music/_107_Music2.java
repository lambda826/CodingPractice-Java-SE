package oop.polymorphism.music;

public class _107_Music2 {

    public static void tune(_103_Wind i) {
        i.play(_101_Note.MIDDLE_C);
    }

    public static void tune(_105_Stringed i) {
        i.play(_101_Note.MIDDLE_C);
    }

    public static void tune(_106_Brass i) {
        i.play(_101_Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        _103_Wind flute = new _103_Wind();
        _105_Stringed violin = new _105_Stringed();
        _106_Brass frenchHorn = new _106_Brass();
        tune(flute);
        tune(violin);
        tune(frenchHorn);
    }
}