package java8.lambda.interfaces;

// (String) -> (String)
@FunctionalInterface
public interface StringFunc {
    String apply(String str);
}