/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 1:23:10 PM
 */

package autoBoxing;

public class AutoBox5 {

    public static void main(String[] args) {
        Boolean b = true;

        if (b) {
            System.out.println("b is true");

            Character ch = 'x';

            char ch2 = ch;
            System.out.println("ch2 is " + ch2);
        }
    }
}
