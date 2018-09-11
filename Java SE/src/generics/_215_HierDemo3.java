/**
 *  @author  Yunxiang He
 *  @date    Mar 1, 2018 6:22:33 PM
 */

package generics;

public class _215_HierDemo3 {
    public static void main(String args[]) {

        _201_Gen<Integer> iOb = new _201_Gen<Integer>(88);

        _212_Gen2<Integer> iOb2 = new _212_Gen2<Integer>(99);

        _212_Gen2<String> strOb2 = new _212_Gen2<String>("_101_Generics Test");

        if (iOb2 instanceof _212_Gen2<?>)
            System.out.println("iOb2 is instance of _112_Gen2");

        if (iOb2 instanceof _201_Gen<?>)
            System.out.println("iOb2 is instance of _101_Gen");

        System.out.println();

        if (strOb2 instanceof _212_Gen2<?>)
            System.out.println("strOb is instance of _112_Gen2");

        if (strOb2 instanceof _201_Gen<?>)
            System.out.println("strOb is instance of _101_Gen");

        System.out.println();

        if (iOb instanceof _212_Gen2<?>)
            System.out.println("iOb is instance of _112_Gen2");

        if (iOb instanceof _201_Gen<?>)
            System.out.println("iOb is instance of _101_Gen");

        // The following can't be compiled because _101_Generic type info does not exist at run-time. 
        //        if (iOb2 instanceof _112_Gen2<Integer>)
        //            System.out.println("iOb2 is instance of _112_Gen2<Integer>");
    }
}
