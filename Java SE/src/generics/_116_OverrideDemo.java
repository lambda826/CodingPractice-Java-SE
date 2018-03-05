/**
 *  @author  Yunxiang He
 *  @date    Mar 1, 2018 6:32:13 PM
 */

package generics;

/*



 */

public class _116_OverrideDemo {

    public static void main(String args[]) {

        // Create a _101_Gen object for Integers. 
        _101_Gen<Integer> iOb = new _101_Gen<Integer>(88);

        // Create a _112_Gen2 object for Integers. 
        _112_Gen2<Integer> iOb2 = new _112_Gen2<Integer>(99);

        // Create a _112_Gen2 object for Strings. 
        _112_Gen2<String> strOb2 = new _112_Gen2<String>("Generics Test");

        System.out.println(iOb.getob());
        System.out.println(iOb2.getob());
        System.out.println(strOb2.getob());
    }
}
