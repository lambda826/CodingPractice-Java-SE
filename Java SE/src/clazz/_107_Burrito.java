package clazz;

public class _107_Burrito {
    Spiciness degree;

    public _107_Burrito(Spiciness degree) {
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
        _107_Burrito plain = new _107_Burrito(Spiciness.NOT), greenChile = new _107_Burrito(Spiciness.MEDIUM), jalapeno = new _107_Burrito(Spiciness.HOT);
        plain.describe();
        greenChile.describe();
        jalapeno.describe();
    }
}

enum Spiciness {
    NOT, MILD, MEDIUM, HOT, FLAMING
}