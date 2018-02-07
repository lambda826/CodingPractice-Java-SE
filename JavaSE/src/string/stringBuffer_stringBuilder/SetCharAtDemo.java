/**
 *  @author  Yunxiang He
 *  @date    Feb 2, 2018 1:13:20 PM
 */

package string.stringBuffer_stringBuilder;

public class SetCharAtDemo {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println(sb.capacity()); // 21
        System.out.println(sb.length()); // 5
        System.out.println(sb.charAt(1)); // e
        sb.setLength(2);
        System.out.println(sb);
        sb.setCharAt(1, 'i');
        System.out.println(sb.charAt(1));
        System.out.println(sb);
    }
}
