/**
 *  @author  Yunxiang He
 *  @date    Feb 4, 2018 5:55:21 AM
 */

package design_pattern.behavioral.strategy.demo1;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
