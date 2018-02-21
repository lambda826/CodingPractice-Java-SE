/**
 *  @author  Yunxiang He
 *  @date    Feb 19, 2018 1:16:31 AM
 */

package enumerations._01_enums;


public enum Apple3 {
    Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8);

    private int price; 

    // Constructor 
    Apple3(int p) {
        price = p;
    }

    // Overloaded constructor 
    Apple3() {
        price = -1;
    }

    int getPrice() {
        return price;
    }
}
