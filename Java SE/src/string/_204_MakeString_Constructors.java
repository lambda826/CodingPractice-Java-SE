/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-12 02:14
 */

package string;

public class _204_MakeString_Constructors {
    public static void main(String args[]) {
        char c[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
        byte ascii[] = { 65, 66, 67, 68, 69, 70 };
        int codePoints[] = { 65, 66, 67, 68, 69, 70 };
        String s1 = new String();
        String s2 = new String(c);
        String s3 = new String(s2);
        String s4 = new String(c, 2, 3);
        String s5 = new String(ascii);
        String s6 = new String(ascii, 2, 3);
        String s7 = new String(codePoints, 2, 3);

        System.out.println(s2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
    }
}
