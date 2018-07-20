package string;

import java.io.*;
import java.util.*;

public class _108_Turtle {
    private String name;
    private Formatter f;

    public _108_Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        _108_Turtle tommy = new _108_Turtle("Tommy", new Formatter(System.out));
        _108_Turtle terry = new _108_Turtle("Terry", new Formatter(outAlias));
        tommy.move(0, 0);
        terry.move(4, 8);
        tommy.move(3, 4);
        terry.move(2, 5);
        tommy.move(3, 3);
        terry.move(3, 3);
    }
}