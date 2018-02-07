/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 3:52:59 AM
 */

package enumerations;

public class ValuesAndValueOfDemo {

    public static void main(String[] args) {
        Apple ap;

        System.out.println("Here are all Apple constants: ");

        Apple[] allApples = Apple.values();
        for (Apple a : allApples) {
            System.out.println(a);
        }

        System.out.println();

        ap = Apple.valueOf("Winesap");
        System.out.println(ap);
        
        // java.lang.IllegalArgumentException: No enum constant enumerations.Apple._Winesap
        ap = Apple.valueOf("_Winesap");
        System.out.println(ap);
    }
}
