/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 1:25:55 PM
 */

package autoBoxing;

public class UnboxingError {

    public static void main(String[] args) {
        Integer iOb = 1000;

        int i = iOb.byteValue();

        System.out.println(i);
    }
}
