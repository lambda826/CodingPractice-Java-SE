package oop.inheritance;

class Engine {

    public void start() {
    }

    public void rev() {
    }

    public void stop() {
    }

}

class Wheel {

    public void inflate(int psi) {
    }

}

class Window {

    public void rollup() {
    }

    public void rolldown() {
    }

}

class Door {

    public Window window = new Window();

    public void open() {
    }

    public void close() {
    }

}

public class _112_Car {

    // Sometimes it makes sense to allow the class user to directly access the composition of your new class; 
    // that is, to make the member objects public. 
    // The member objects use implementation hiding themselves, so this is a safe thing to do
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door left = new Door();
    public Door right = new Door();

    public _112_Car() {
        for (int i = 0; i < 4; i++)
            wheel[i] = new Wheel();
    }

    public static void main(String[] args) {
        _112_Car car = new _112_Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
    }

}
