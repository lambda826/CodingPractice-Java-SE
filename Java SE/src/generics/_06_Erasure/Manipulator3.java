package generics._06_Erasure;

/*
 * Generics are only useful when you want to use type parameters that are more "generic" than a specific type (and all its subtypes)
 * that is, when you want code to work across multiple classes
 */
class Manipulator3 {
    private HasF obj;

    public Manipulator3(HasF x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}