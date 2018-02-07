/**
 *  @author  Yunxiang He
 *  @date    Feb 2, 2018 11:58:19 AM
 */

package string.comparison;

public class CompareToDemo {

    public static void main(String[] args) {
        String str1 = "abzab";
        String str2 = "Azzzz";
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareToIgnoreCase(str2));
    }
}
