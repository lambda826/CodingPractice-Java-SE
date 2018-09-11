package generics;

class _134_ReturnGenericType<T extends _130_HasF> {
    private T obj;

    public _134_ReturnGenericType(T x) {
        obj = x;
    }

    public T get() {
        return obj;
    }
}