package generics;

public class _140_GenericHolder<T> {

    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        _140_GenericHolder<String> holder = new _140_GenericHolder<String>();
        holder.set("Item");
        // The need for the cast from get( ) has disappeared, but we also know that the value passed to set( ) is being type-checked at compile time
        String s = holder.get();
    }
}
