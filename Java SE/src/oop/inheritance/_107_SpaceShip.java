package oop.inheritance;

public class _107_SpaceShip extends _106_SpaceShipControls {

    private String name;

    public _107_SpaceShip(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        _107_SpaceShip protector = new _107_SpaceShip("NSEA Protector");
        protector.forward(100);
    }

}