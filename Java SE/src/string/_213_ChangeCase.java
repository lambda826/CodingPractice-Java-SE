/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-12 02:22
 */

package string;

public class _213_ChangeCase {
    public static void main(String args[]) {
        String s = "This is a test.";

        System.out.println("Original: " + s);

        String upper = s.toUpperCase();
        String lower = s.toLowerCase();

        System.out.println("Uppercase: " + upper);
        System.out.println("Lowercase: " + lower);
    }
}
