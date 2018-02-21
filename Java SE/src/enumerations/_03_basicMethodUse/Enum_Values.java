/**
 *  @author  Yunxiang He
 *  @date    Feb 19, 2018 1:13:12 AM
 */

package enumerations._03_basicMethodUse;

import enumerations._01_enums.Apple2;

public class Enum_Values {
    public static void main(String args[]) {
        // Display price of Winesap. 
        System.out.println("Winesap costs " + Apple2.Winesap.getPrice() + " cents.\n");

        // Display all apples and prices. 
        System.out.println("All apple prices:");
        for (Apple2 a : Apple2.values())
            System.out.println(a + " costs " + a.getPrice() + " cents.");
    }
}
