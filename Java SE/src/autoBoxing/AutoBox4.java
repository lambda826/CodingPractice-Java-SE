/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 1:22:04 PM
 */

package autoBoxing;

public class AutoBox4 {

    public static void main(String[] args) {
        Integer iOb = 100;
        Double dOb = 98.6;
        dOb = iOb + dOb;
        System.out.println("dOb after expression : " + dOb);
    }
}
