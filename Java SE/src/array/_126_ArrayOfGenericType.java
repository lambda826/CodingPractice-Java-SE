package array;

public class _126_ArrayOfGenericType<T> {
    T[] array;

    @SuppressWarnings("unchecked")
    public _126_ArrayOfGenericType(int size) {
        // Illegal
        //! array = new T[size]; 
        array = (T[]) new Object[size];
    }
    // Illegal:
    //! public <U> U[] makeArray() { return new U[10]; }
}
