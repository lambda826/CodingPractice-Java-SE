/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:41:37 AM
 */

package lambda;

/*



 */

class MyStringOps2 {
    // A static method that reverses a string. 
    static String strReverse(String str) {
        String result = "";
        int i;

        for (i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);

        return result;
    }
}

public class _110_MethodRefDemo2 {

    // This method has a functional interface as the type of 
    // its first parameter. Thus, it can be passed any instance 
    // of that interface, including a method reference. 
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String args[]) {
        String inStr = "Lambdas add power to Java";
        String outStr;

        // Here, a method reference to strReverse is passed to stringOp(). 
        outStr = stringOp(MyStringOps2::strReverse, inStr);

        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
    }
}