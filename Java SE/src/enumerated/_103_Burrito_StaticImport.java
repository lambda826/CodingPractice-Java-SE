package enumerated;

import static enumerated._102_Spiciness.*;

public class _103_Burrito_StaticImport {
    _102_Spiciness degree;

    public _103_Burrito_StaticImport(_102_Spiciness degree) {
        this.degree = degree;
    }

    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        // Static imports with enums
        System.out.println(new _103_Burrito_StaticImport(NOT));
        System.out.println(new _103_Burrito_StaticImport(MEDIUM));
        System.out.println(new _103_Burrito_StaticImport(HOT));
    }
}