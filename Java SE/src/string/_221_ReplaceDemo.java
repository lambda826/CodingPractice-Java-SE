/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-12 02:21
 */

package string;

public class _221_ReplaceDemo {
    public static void main(String args[]) {
        StringBuffer sb = new StringBuffer("This is a test.");

        sb.replace(5, 7, "was");
        System.out.println("After replace: " + sb);
    }
}
