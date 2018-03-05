/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 10:36:46 AM
 */

package generics;

public class _101_GenDemo {
    public static void main(String args[]) {
        // Create a Gen reference for Integers.  
        _101_Gen<Integer> iOb;

        // Create a Gen<Integer> object and assign its reference to iOb
        // Notice the use of autoboxing to encapsulate the value 88 within an Integer object
        iOb = new _101_Gen<Integer>(88);
        iOb.showType();
        int v = iOb.getob();
        System.out.println("value: " + v);

        System.out.println();

        // Create a Gen object for Strings
        _101_Gen<String> strOb = new _101_Gen<String>("Generics Test");
        strOb.showType();
        String str = strOb.getob();
        System.out.println("value: " + str);
    }
}
