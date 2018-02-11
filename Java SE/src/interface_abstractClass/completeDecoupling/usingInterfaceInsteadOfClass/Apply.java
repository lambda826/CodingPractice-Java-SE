/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 9:25:34 PM
 */

package interface_abstractClass.completeDecoupling.usingInterfaceInsteadOfClass;

public class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
