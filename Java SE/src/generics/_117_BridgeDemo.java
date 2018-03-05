/**
 *  @author  Yunxiang He
 *  @date    Mar 1, 2018 6:47:27 PM
 */

package generics;

// In the program, the subclass Gen2 extends Gen, but does so using a String-specific version of Gen
class Gen22 extends _101_Gen<String> {

    Gen22(String o) {
        super(o);
    }

    // A String-specific override of getob()
    // Notice that the only difference between the two getob( ) methods is their return type
    // Normally, this would cause an error
    // But because this does not occur in your source code, it does not cause a problem and is handled correctly by the JVM.
    public String getob() {
        System.out.print("You called String getob(): ");
        return ob;
    }
}

public class _117_BridgeDemo {
    public static void main(String args[]) {

        Gen22 strOb2 = new Gen22("Generics Test");

        System.out.println(strOb2.getob());
    }
}
