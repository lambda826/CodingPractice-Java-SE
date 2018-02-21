package enumerations._04_useEnum;

// Enums in switch statements.
import static util.Print.print;

// Define an enum type:
enum Signal {
    GREEN, YELLOW, RED,
}

public class TrafficLight_Switch {
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

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight_Switch t = new TrafficLight_Switch();
        for (int i = 0; i < 7; i++) {
            print(t);
            t.change();
        }
    }
}