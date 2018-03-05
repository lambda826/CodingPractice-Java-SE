package generics._01_SimpleGenerics;

// One of the primary motivations for generics is to specify what type of object a container holds, and to have that specification backed up by the compiler
public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        // Now when you create a Holders, you must specify what type you want to put into it using the same angle-bracket syntax
        Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
        // No cast needed
        Automobile a = h3.get();

        // Error
        // You are only allowed to put objects of that type (or a subtype, since the substitution principle still works with generics) into the holder

        // h3.set("Not an Automobile"); 
        // h3.set(1);
    }
}
