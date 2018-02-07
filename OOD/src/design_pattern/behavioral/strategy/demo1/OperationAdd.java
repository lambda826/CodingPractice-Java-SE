/**
 *  @author  Yunxiang He
 *  @date    Feb 4, 2018 5:52:17 AM
 */

package design_pattern.behavioral.strategy.demo1;

public class OperationAdd implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }

}
