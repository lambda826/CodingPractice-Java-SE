/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 10:36:46 AM
 */

package generics._02_genericDeom;

import generics._01_simpleGeneric.Gen;

public class GenDemo {
    public static void main(String args[]) {
        // Create a Gen reference for Integers.  
        Gen<Integer> iOb;

        // Create a Gen<Integer> object and assign its reference to iOb
        // Notice the use of autoboxing to encapsulate the value 88 within an Integer object
        iOb = new Gen<Integer>(88);
        iOb.showType();
        int v = iOb.getob();
        System.out.println("value: " + v);

        System.out.println();

        // Create a Gen object for Strings
        Gen<String> strOb = new Gen<String>("Generics Test");
        strOb.showType();
        String str = strOb.getob();
        System.out.println("value: " + str);
    }
}
