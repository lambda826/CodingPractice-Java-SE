/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-12 02:20
 */

package string;

public class _217_AppendDemo {
    public static void main(String args[]) {
        int a = 42;
        StringBuffer sb = new StringBuffer(40);

        String s = sb.append("a = ").append(a).append("!").toString();
        System.out.println(s);
    }
}
