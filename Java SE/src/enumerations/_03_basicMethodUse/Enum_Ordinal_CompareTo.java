/**
 *  @author  Yunxiang He
 *  @date    Feb 19, 2018 1:34:49 AM
 */

package enumerations._03_basicMethodUse;

import enumerations._01_enums.Apple;

public class Enum_Ordinal_CompareTo {

    public static void main(String args[]) {
        Apple ap, ap2, ap3;

        // Obtain all ordinal values using ordinal(). 
        System.out.println("Here are all apple constants" + " and their ordinal values: ");
        for (Apple a : Apple.values())
            System.out.println(a + " " + a.ordinal());

        ap = Apple.RedDel;
        ap2 = Apple.GoldenDel;
        ap3 = Apple.RedDel;

        System.out.println();

        // Demonstrate compareTo() and equals() 
        if (ap.compareTo(ap2) < 0)
            System.out.println(ap + " comes before " + ap2);

        if (ap.compareTo(ap2) > 0)
            System.out.println(ap2 + " comes before " + ap);

        if (ap.compareTo(ap3) == 0)
            System.out.println(ap + " equals " + ap3);

        System.out.println();

        if (ap.equals(ap2))
            System.out.println("Error!");

        if (ap.equals(ap3))
            System.out.println(ap + " equals " + ap3);

        if (ap == ap3)
            System.out.println(ap + " == " + ap3);

    }
}
