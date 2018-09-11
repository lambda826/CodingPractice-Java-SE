package generics;

/*
 * Erasure loses the ability to perform certain operations in generic code.
 * Anything that requires the knowledge of the exact type at run time won’t work
 */
public class _141_Erased<T> {
    private static final int SIZE = 100;

    public static void f(Object arg) {
        //        if (arg instanceof T) {} // Error
        //        T var = new T(); // Error
        //        T[] array = new T[SIZE]; // Error
        //        T[] array = (T) new Object[SIZE]; // Unchecked warning
    }
}