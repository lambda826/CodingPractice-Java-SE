/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:38:35 AM
 */

package lambda;

interface NumericFunc {
    int func(int n);
}

class _104_BlockLambdaDemo {
    public static void main(String args[]) {

        // This block lambda computes the factorial of an int value
        NumericFunc factorial = (n) -> {
            int result = 1;

            for (int i = 1; i <= n; i++)
                result = i * result;

            return result;
        };

        System.out.println("The factoral of 3 is " + factorial.func(3));
        System.out.println("The factoral of 5 is " + factorial.func(5));
    }
}
