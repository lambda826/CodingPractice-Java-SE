package generics;

class Generic<T> {
}

public class _147_ArrayOfGenericReference {
    //You can define a reference to create an array of generic types
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        gia = new Generic[10];
        // But you can never create an array of that exact type
//                gia = new Generic<Integer>[10];
    }
}