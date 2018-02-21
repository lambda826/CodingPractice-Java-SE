//: enumerated/Burrito.java
package enumerations._04_useEnum;

import static enumerations._01_enums.Spiciness.*;

import enumerations._01_enums.Spiciness;

public class Burrito_StaticImport {
    Spiciness degree;

    public Burrito_StaticImport(Spiciness degree) {
        this.degree = degree;
    }

    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        // The static import brings all the enum instance identifiers into the local namespace, so they don’t need to be qualified
        System.out.println(new Burrito_StaticImport(NOT));
        System.out.println(new Burrito_StaticImport(MEDIUM));
        System.out.println(new Burrito_StaticImport(HOT));
    }
}