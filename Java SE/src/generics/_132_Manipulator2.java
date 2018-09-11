package generics;

/*
 * In order to call f(), we must assist the generic class by giving it a bound that tells the compiler to only accept types that conform to that bound
 * We say that a generic type parameter erases to its first bound (it’s possible to have multiple bounds). 
 * We also talk about the erasure of the type parameter. 
 * The compiler actually replaces the type parameter with its erasure, so in the above case, T erases to HasF, which is the same as replacing T with HasF in the class body
 */
class _132_Manipulator2<T extends _130_HasF> {

    private T obj;

    public _132_Manipulator2(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}
