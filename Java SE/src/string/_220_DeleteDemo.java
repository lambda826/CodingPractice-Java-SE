/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-12 02:21
 */

package string;

public class _220_DeleteDemo {
    public static void main(String args[]) {
        StringBuffer sb = new StringBuffer("This is a test.");

        sb.delete(4, 7);
        System.out.println("After delete: " + sb);

        sb.deleteCharAt(0);
        System.out.println("After deleteCharAt: " + sb);
    }
}
