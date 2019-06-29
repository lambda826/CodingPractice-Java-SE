/**
 *  @author Yunxiang He
 *  @date   06/23/2019
 */

package javaSe.foundation.io;

import java.util.Random;

public class T {

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 100000; ++i) {
            System.out.println("(" + "\"" + (rand.nextInt(10) + 1) + "\"" + ", " + "\"" + rand.nextInt(10000) + "\"" + "),");
        }
    }
}
