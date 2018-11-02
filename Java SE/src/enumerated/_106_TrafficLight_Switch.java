package enumerated;

import static utils.Print.*;

enum Signal {
    GREEN, YELLOW, RED,
}

public class _106_TrafficLight_Switch {
    
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
        // Note that you don't have to say Signal.RED in the case statement:
        case RED:
            color = Signal.GREEN;
            break;
        case GREEN:
            color = Signal.YELLOW;
            break;
        case YELLOW:
            color = Signal.RED;
            break;
        }
    }

    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        _106_TrafficLight_Switch t = new _106_TrafficLight_Switch();
        for (int i = 0; i < 7; i++) {
            print(t);
            t.change();
        }
    }
}