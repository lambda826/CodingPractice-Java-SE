//: initialization/EnumOrder.java
package enumerations._03_basicMethodUse;

import enumerations._01_enums.Spiciness;

public class Enum_Ordinal {
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values())
            System.out.println(s + ", ordinal " + s.ordinal());
    }
}