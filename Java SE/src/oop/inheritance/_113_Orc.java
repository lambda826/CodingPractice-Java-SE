package oop.inheritance;

import static utils.Print.*;

class Villain {

    private String name;

    protected void set(String nm) {
        name = nm;
    }

    public Villain(String name) {
        this.name = name;
    }

    public String toString() {
        return "I'm a Villain and my name is " + name;
    }

}

public class _113_Orc extends Villain {

    private int orcNumber;

    public _113_Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        // Available because it’s protected
        set(name);
        this.orcNumber = orcNumber;
    }

    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        _113_Orc orc = new _113_Orc("Limburger", 12);
        print(orc);
        orc.change("Bob", 19);
        print(orc);
    }

}