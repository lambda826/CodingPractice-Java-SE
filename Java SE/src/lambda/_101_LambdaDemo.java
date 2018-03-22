/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:36:53 AM
 */

package lambda;

interface MyNumber {
    double getValue();
}

public class _101_LambdaDemo {
    public static void main(String args[]) {
        MyNumber myNum;

        // Here, the lambda expression is simply a constant expression 
        // When it is assigned to myNum, a class instance is constructed in which the lambda expression provides an override of the getValue() method in MyNumber
        myNum = () -> 123.45;

        // Call getValue(), which is overridden by the previously assigned lambda expression
        System.out.println("A fixed value: " + myNum.getValue());

        // Here, a more complex expression is used
        myNum = () -> Math.random() * 100;

        // These call the lambda expression in the previous line
        System.out.println("A random value: " + myNum.getValue());
        System.out.println("Another random value: " + myNum.getValue());

        // A lambda expression must be compatible with the method defined by the functional interface
        // Therefore, this won't work: 
        // Error! 
        //        myNum = () -> "123.03";
    }
}
