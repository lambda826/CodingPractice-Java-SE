/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:42:27 AM
 */

package lambda;

class MyStringOps2 {
    // A non-static method that reverses a string
    String strReverse(String str) {
        String result = "";
        int i;

        for (i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);

        return result;
    }
}

public class _111_MethodRefDemo2 {

    // This method has a functional interface as the type of its first parameter
    // Thus, it can be passed any instance of that interface, including method references
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String args[]) {
        String inStr = "Lambdas add power to Java";
        String outStr;

        // Create a MyStringOps2 object
        MyStringOps2 strOps = new MyStringOps2();

        // Now, a method reference to the instance method strReverse is passed to stringOp() 
        outStr = stringOp(strOps::strReverse, inStr);

        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
    }
}