/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 2:36:31 AM
 */

package inheritance_Interface.ocp;

public class Helicopter extends Rotorcraft {

    private int height = 10;

    protected int fly() {
        return super.height;
    }

    public static void main(String[] args) {
        Helicopter helicopter = new Helicopter();
        System.out.println(helicopter.fly());
    }

}

abstract class Rotorcraft {
    protected final int height = 5;

    abstract int fly();
}
