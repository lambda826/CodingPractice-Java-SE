/**
 *  @author  Yunxiang He
 *  @date    Feb 19, 2018 1:09:44 AM
 */

package enumerations._01_enums;

public enum Apple2 {
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);

    // Instance variable
    private int price;

    // Constructor 
    Apple2(int p) {
        price = p;
    }

    // Instance method
    public int getPrice() {
        return price;
    }
}
