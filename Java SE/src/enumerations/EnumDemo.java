/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 3:46:25 AM
 */

package enumerations;

public class EnumDemo {

    public static void main(String[] args) {
        Apple ap;
        ap = Apple.RedDel;

        System.out.println("Value of ap:" + ap);
        System.out.println();

        ap = Apple.GoldenDel;

        if (Apple.GoldenDel == ap) {
            System.out.println("ap contains GoldenDel. \n");
        }

        switch (ap) {
        case Jonathan:
            System.out.println("Jonathan is red.");
            break;
        case GoldenDel:
            System.out.println("Golden Delicious is yellow.");
            break;
        case RedDel:
            System.out.println("Red Delicious is red.");
            break;
        case Winesap:
            System.out.println("Winesap is red.");
            break;
        case Cortland:
            System.out.println("Cortland is red.");
            break;
        }
    }
}
