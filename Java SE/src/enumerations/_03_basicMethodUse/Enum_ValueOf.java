/**
 *  @author  Yunxiang He
 *  @date    Feb 19, 2018 1:06:12 AM
 */

package enumerations._03_basicMethodUse;

import enumerations._01_enums.Apple;

public class Enum_ValueOf {
    public static void main(String args[]) {
        Apple ap;

        System.out.println("Here are all Apple constants :");

        // use values() 
        Apple allapples[] = Apple.values();
        for (Apple apple : allapples)
            System.out.println(apple);

        System.out.println();

        // use valueOf() 
        ap = Apple.valueOf("Winesap");
        System.out.println("ap contains " + ap);

    }
}