/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 9:25:13 PM
 */

package interface_abstractClass.completeDecoupling.usingInterfaceInsteadOfClass;

public interface Processor {
    String name();

    Object process(Object input);
}