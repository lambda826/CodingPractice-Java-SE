package oop.inheritance;

import static utils.Print.print;

class Art {
    Art() {
        print("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        print("Drawing constructor");
    }
}

public class _104_Cartoon extends Drawing {

    public _104_Cartoon() {
        print("Cartoon constructor");
    }

    public static void main(String[] args) {
        _104_Cartoon x = new _104_Cartoon();
    }
}