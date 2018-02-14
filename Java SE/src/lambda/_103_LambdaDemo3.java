/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:38:11 AM
 */

package lambda;

/*



 */

public class _103_LambdaDemo3 {
    public static void main(String args[]) {
        // This lambda expression determines if one number is  
        // a factor of another. 
        NumericTest2 isFactor = (n, d) -> (n % d) == 0;

        if (isFactor.test(10, 2))
            System.out.println("2 is a factor of 10");

        if (!isFactor.test(10, 3))
            System.out.println("3 is not a factor of 10");
    }
}

interface NumericTest2 {
    boolean test(int n, int d);
}
