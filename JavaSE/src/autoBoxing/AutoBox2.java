/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 1:13:36 PM
 */

package autoBoxing;

public class AutoBox2 {

    static int m(Integer v) {
        return v;
    }

    public static void main(String[] args) {
        Integer iOb = m(100);
        System.out.println(iOb);
    }
}
