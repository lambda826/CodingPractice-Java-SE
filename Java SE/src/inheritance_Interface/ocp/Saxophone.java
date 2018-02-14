/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 1:44:39 AM
 */

package inheritance_Interface.ocp;

public class Saxophone extends Woodwind implements Horn {
    //    public Number play() {
    public Short play() { // cannot be greater than superclass or interface
        return 0;
    }
}

interface Horn {
    //    public Integer play();
    public Short play(); // cannot cast the type
}

abstract class Woodwind {
    public abstract Short play();
}