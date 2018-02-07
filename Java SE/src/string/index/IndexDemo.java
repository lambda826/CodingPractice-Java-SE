/**
 *  @author  Yunxiang He
 *  @date    Feb 2, 2018 12:07:52 PM
 */

package string.index;

public class IndexDemo {

    public static void main(String[] args) {
        String str1 = "Yunxiang He is a USC graduate student";

        System.out.println(str1.indexOf("a"));
        System.out.println(str1.indexOf("a", 6));
        System.out.println(str1.lastIndexOf("a"));
        System.out.println(str1.lastIndexOf("a", 5));
    }
}
