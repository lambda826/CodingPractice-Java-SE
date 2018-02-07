/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 1:09:25 PM
 */

package autoBoxing;

public class Wrap {

    public static void main(String[] args) {
        
        Integer iOb = Integer.valueOf(100);

        int i = iOb.intValue();

        System.out.println(i + " " + iOb);
        
    }
}
