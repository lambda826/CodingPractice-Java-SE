/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 1:52:53 AM
 */

package inheritance_Interface.ocp;

public class Encyclopedia extends Book {
    public static String material = "cellulose";

    public Encyclopedia() {
        super();
    }

    public String getMaterial() {
        return super.material;
    }

    public static void main(String[] args) {
        System.out.println(new Encyclopedia().getMaterial());
    }
}

abstract class Book {
    protected static String material = "papyrus";

    public Book() {

    }

    public Book(String material) {
        this.material = material;
    }
}
