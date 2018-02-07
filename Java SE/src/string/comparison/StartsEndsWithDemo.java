/**
 *  @author  Yunxiang He
 *  @date    Feb 2, 2018 11:35:58 AM
 */

package string.comparison;

public class StartsEndsWithDemo {

    public static void main(String[] args) {
        String str1 = "Yunxiang He";
        System.out.println(str1.startsWith("Yunxiang"));
        System.out.println(str1.startsWith("xiang", 3));
        System.out.println(str1.endsWith("He"));

    }
}
