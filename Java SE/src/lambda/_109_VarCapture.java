/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:41:04 AM
 */

package lambda;

interface MyFunc {
    int func(int n);
}

public class _109_VarCapture {

    int i = 0;

    public static void main(String args[]) {
        // A local variable that can be captured
        int num = 10;

        MyFunc myLambda = (n) -> {

            // This use of num is OK
            // It does not modify num
            int v = num + n;

            // However, the following is illegal because it attempts to modify the value of num
            //      num++; 

            return v;
        };

        // The following line would also cause an error, because 
        // it would remove the effectively final status from num. 
        //  num = 9; 
    }

    public void nonStaticMethod() {
        MyFunc myFunc = (i) -> {
            this.i = i;
            return 5;
        };
    }
}
