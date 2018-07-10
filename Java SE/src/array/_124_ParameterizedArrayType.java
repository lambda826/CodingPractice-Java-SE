package array;

class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

// Note the convenience of using a parameterized method instead of a parameterized class: 
// You don’t have to instantiate a class with a parameter for each different type you need to apply it to,
// and you can make it static
class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}

public class _124_ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = { 1, 2, 3, 4, 5 };
        Double[] doubles = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = new ClassParameter<Double>().f(doubles);
        ints2 = MethodParameter.f(ints);
        doubles2 = MethodParameter.f(doubles);
    }
}
