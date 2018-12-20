package oop.polymorphism.shape;

public class _106_Shapes {
    private static _105_RandomShapeGenerator gen = new _105_RandomShapeGenerator();

    public static void main(String[] args) {

        _101_Shape[] s = new _101_Shape[9];
        for (int i = 0; i < s.length; i++) {
            s[i] = gen.next();
        }
        for (_101_Shape shp : s) {
            shp.draw();
        }
    }
}