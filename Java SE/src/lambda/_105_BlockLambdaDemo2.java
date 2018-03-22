/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:38:58 AM
 */

package lambda;

interface StringFunc {
    String func(String n);
}

public class _105_BlockLambdaDemo2 {
    public static void main(String args[]) {

        // This block lambda that reverses the charactrers in a string
        StringFunc reverse = (str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);

            return result;
        };

        System.out.println("Lambda reversed is " + reverse.func("Lambda"));
        System.out.println("Expression reversed is " + reverse.func("Expression"));
    }
}
