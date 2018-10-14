package oop.inheritance;

public class _108_SpaceShipDelegation {

    private String name;
    private _106_SpaceShipControls controls = new _106_SpaceShipControls();

    public _108_SpaceShipDelegation(String name) {
        this.name = name;
    }

    // Delegated methods:
    public void back(int velocity) {
        controls.back(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void turboBoost() {
        controls.turboBoost();
    }

    public void up(int velocity) {
        controls.up(velocity);
    }

    public static void main(String[] args) {
        _108_SpaceShipDelegation protector = new _108_SpaceShipDelegation("NSEA Protector");
        protector.forward(100);
    }

}