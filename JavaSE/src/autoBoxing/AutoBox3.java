/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 1:15:01 PM
 */

package autoBoxing;

public class AutoBox3 {

    public static void main(String[] args) {
        Integer iOb;
        Integer IOb2;
        int i;

        iOb = 100;
        System.out.println("Original value of iOb: " + iOb);

        ++iOb;
        System.out.println("After ++iOb: " + iOb);

        IOb2 = iOb + (iOb / 3);

        System.out.println("iOb3 after expression: " + IOb2);

        i = iOb + (iOb / 3);
        System.out.println("i after expression: " + i);

    }

}
