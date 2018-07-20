/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-12 02:19
 */

package string;

public class _214_StringJoinDemo {
    public static void main(String args[]) {

        String result = String.join(" ", "Alpha", "Beta", "Gamma");
        System.out.println(result);

        result = String.join(", ", "John", "ID#: 569", "E-mail: John@HerbSchildt.com");
        System.out.println(result);
    }
}
