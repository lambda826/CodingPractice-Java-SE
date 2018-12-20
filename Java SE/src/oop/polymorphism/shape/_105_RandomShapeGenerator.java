package oop.polymorphism.shape;

import java.util.*;

public class _105_RandomShapeGenerator {

    private Random rand = new Random(47);

    public _101_Shape next() {
        switch (rand.nextInt(3)) {
        default:
        case 0:
            return new _102_Circle();
        case 1:
            return new _103_Square();
        case 2:
            return new _104_Triangle();
        }
    }

}