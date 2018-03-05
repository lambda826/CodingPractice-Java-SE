package generics._09_Wildcards;

public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<Apple>(new Apple());
        Apple d = Apple.get();
        Apple.set(d);

        // Cannot upcast
        // Holder<Fruit> Fruit = Apple; 

        // OK
        // If you create a Holder<Apple>, you cannot upcast it to a Holder<Fruit>, but you can upcast to a Holder<? extends Fruit>
        Holder<? extends Fruit> fruit = Apple;
        Fruit p = fruit.get();
        // Returns 'Object'
        d = (Apple) fruit.get();
        try {
            Orange c = (Orange) fruit.get(); // No warning
        } catch (Exception e) {
            System.out.println(e);
        }
        // Cannot call set()
        // fruit.set(new Apple()); 

        // Cannot call set()
        // fruit.set(new Fruit());

        // OK
        System.out.println(fruit.equals(d));
    }
}