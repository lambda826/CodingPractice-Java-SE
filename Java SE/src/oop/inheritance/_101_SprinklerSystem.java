package oop.inheritance;

class WaterSource {

    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    public String toString() {
        return s;
    }
}

public class _101_SprinklerSystem {

    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    public String toString() {
        return "valve1 = " + valve1 + " " + "valve2 = " + valve2 + " " + "valve3 = " + valve3 + " " + "valve4 = " + valve4 + "\n" + "i = " + i + " " + "f = " + f + " " + "source = " + source;
    }

    public static void main(String[] args) {
        _101_SprinklerSystem sprinklers = new _101_SprinklerSystem();
        System.out.println(sprinklers);
    }
}