/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 4:29:21 PM
 */

package exceptions;

import static common.utils.Print.print;

/*

Because a finally clause is always executed,
it’s possible to return from multiple points within a method and still guarantee that important cleanup will be performed

 */

public class MultipleReturns {
    public static void f(int i) {
        print("Initialization that requires cleanup");
        try {
            print("Point 1");
            if (i == 1)
                return;
            print("Point 2");
            if (i == 2)
                return;
            print("Point 3");
            if (i == 3)
                return;
            print("End");
            return;
        } finally {
            print("Performing cleanup");
        }
    }

    public static int g() {
        try {
            return 1;
        } finally {
            print("111");
        }

    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++)
            f(i);
        System.out.println(g());
    }
}