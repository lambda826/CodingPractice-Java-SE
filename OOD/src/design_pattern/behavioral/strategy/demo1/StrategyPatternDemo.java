/**
 *  @author  Yunxiang He
 *  @date    Feb 4, 2018 5:56:30 AM
 */

package design_pattern.behavioral.strategy.demo1;

public class StrategyPatternDemo {

    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        System.out.println(context.execStrategy(5, 10));

        context = new Context(new OperationMultiply());
        System.out.println(context.execStrategy(5, 10));

        context = new Context(new OperationSubstract());
        System.out.println(context.execStrategy(5, 10));

    }
}
