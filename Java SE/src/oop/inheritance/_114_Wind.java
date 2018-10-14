package oop.inheritance;

class Instrument {

    public void play() {
    }

    static void tune(Instrument i) {
        i.play();
    }

}

// Wind objects are instruments because they have the same interface:
public class _114_Wind extends Instrument {

    public static void main(String[] args) {
        _114_Wind flute = new _114_Wind();
        Instrument.tune(flute);
    }

}
