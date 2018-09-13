package generics;

/*
 * Because of erasure, the runtime type of the array can only be Object[]. 
 * If we immediately cast it to T[], then at compile time the actual type of the array is lost, and the compiler may miss out on some potential error checks. 
 * Because of this, it’s better to use an Object[] inside the collection, and add a cast to T when you use an array element.
 */
public class _150_GenericArray2<T> {

    // The internal representation is now Object[] rather than T[]
    private Object[] array;

    public _150_GenericArray2(int sz) {
        array = new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) array; // Warning: unchecked cast
    }

    public static void main(String[] args) {
        _150_GenericArray2<Integer> gai = new _150_GenericArray2<Integer>(10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + " ");
        }
        System.out.println();
        try {
            //  if you call rep(), it again attempts to cast the Object[] to a T[], which is still incorrect, 
            Integer[] ia = gai.rep();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}