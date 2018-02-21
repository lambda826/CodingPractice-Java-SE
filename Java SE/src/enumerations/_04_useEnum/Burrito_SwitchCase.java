//: initialization/Burrito.java
package enumerations._04_useEnum;

import enumerations._01_enums.Spiciness;

public class Burrito_SwitchCase {
    Spiciness degree;

    public Burrito_SwitchCase(Spiciness degree) {
        this.degree = degree;
    }

    public void describe() {
        System.out.print("This burrito is ");
        switch (degree) {
        case NOT:
            System.out.println("not spicy at all.");
            break;
        case MILD:
        case MEDIUM:
            System.out.println("a little hot.");
            break;
        case HOT:
        case FLAMING:
        default:
            System.out.println("maybe too hot.");
        }
    }

    public static void main(String[] args) {
        Burrito_SwitchCase plain = new Burrito_SwitchCase(Spiciness.NOT);
        Burrito_SwitchCase greenChile = new Burrito_SwitchCase(Spiciness.MEDIUM);
        Burrito_SwitchCase jalapeno = new Burrito_SwitchCase(Spiciness.HOT);
        plain.describe();
        greenChile.describe();
        jalapeno.describe();
    }
}