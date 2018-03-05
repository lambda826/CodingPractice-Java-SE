package generics._06_Erasure;

/*
 * Erasure loses the ability to perform certain operations in generic code.
 * Anything that requires the knowledge of the exact type at run time won’t work
 */
public class Erased<T> {
    private final int SIZE = 100;

    public static void f(Object arg) {
        //        if (arg instanceof T) {
        //        } // Error
        //        T var = new T(); // Error
        //        T[] array = new T[SIZE]; // Error
        //        T[] array = (T) new Object[SIZE]; // Unchecked warning
    }
}