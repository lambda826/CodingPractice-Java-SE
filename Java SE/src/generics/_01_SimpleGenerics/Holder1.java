package generics._01_SimpleGenerics;

class Automobile {
}

// This is not a very reusable tool, since it can’t be used to hold anything else
public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}
