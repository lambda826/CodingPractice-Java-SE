/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 3:58:26 AM
 */

package enumerations;

public enum EnumDefinesAClass {

    defalutApple, Jonathan(10, 9), GoldenDel(9, 8), RedDel(12, 11), Winesap(15, 14), Cortland(8, 7);

    private int price;
    private int weight;

    EnumDefinesAClass() {
        price = -1;
        weight = -2;
    }

    EnumDefinesAClass(int p, int w) {
        price = p;
        weight = w;
    }

    int getPrice() {
        return price;
    }

    int getWeight() {
        return weight;
    }

    public static void main(String[] args) {

        EnumDefinesAClass ap = defalutApple;
        System.out.println(ap.price);
        System.out.println(ap.weight);

        System.out.println();

        System.out.println("Winesap costs " + EnumDefinesAClass.Winesap.getPrice() + " cents. \n");

        System.out.println("All apple prices: ");
        for (EnumDefinesAClass a : EnumDefinesAClass.values()) {
            System.out.println(a + " costs " + a.getPrice() + " cents.");
        }

        System.out.println();

        System.out.println("All apple weights: ");
        for (EnumDefinesAClass a : EnumDefinesAClass.values()) {
            System.out.println(a + " costs " + a.getWeight() + " cents.");
        }
    }
}
