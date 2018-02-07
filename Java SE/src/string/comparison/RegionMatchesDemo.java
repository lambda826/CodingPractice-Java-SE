/**
 *  @author  Yunxiang He
 *  @date    Feb 2, 2018 11:31:38 AM
 */

package string.comparison;

public class RegionMatchesDemo {

    public static void main(String[] args) {
        String str1 = "    Yunxiang He   ";
        String str2 = "Yunxiang He is a USC graduate student";
        String str3 = "YUNXIANG He is a USC graduate student";

        System.out.println(str1.regionMatches(0, str2, 0, 11));
        System.out.println(str1.regionMatches(true, 4, str3, 0, 11));
    }
}
