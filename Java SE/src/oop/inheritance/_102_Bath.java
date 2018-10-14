package oop.inheritance;

import static utils.Print.print;

/*

If you want the references initialized you can do it:
1. At the point the objects are defined. 
    This means that they’ll always be initialized before the constructor is called.
2. In the constructor for that class.
3. Right before you actually need to use the object. 
    This is often called lazy initialization. 
    It can reduce overhead in situations where object creation is expensive and the object doesn’t need to be created every time.
4. Using instance initialization.

 */

class Soap {
    private String s;

    Soap() {
        print("Soap()");
        s = "Constructed";
    }

    public String toString() {
        return s;
    }
}

public class _102_Bath {
    // Initializing at point of definition:
    private String s1 = "Happy";
    private String s2 = "Happy";
    private String s3;
    private String s4;
    private Soap castille;
    private int i;
    private float toy;

    public _102_Bath() {
        print("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }

    // Instance initialization:
    {
        i = 47;
    }

    public String toString() {
        // Delayed initialization:
        if (s4 == null) {
            s4 = "Joy";
        }
        return "s1 = " + s1 + "\n" + "s2 = " + s2 + "\n" + "s3 = " + s3 + "\n" + "s4 = " + s4 + "\n" + "i = " + i + "\n" + "toy = " + toy + "\n" + "castille = " + castille;
    }

    public static void main(String[] args) {
        _102_Bath b = new _102_Bath();
        print(b);
    }
}