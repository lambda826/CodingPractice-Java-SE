package java8.lambda;

public class _06_Method_Reference {

    public static String stringOp(StringFunc sf, String s) {
        return sf.apply(s);
    }

    public static void main(String args[]) {
        String inStr = "Lambdas add power to Java";
        // Reference to a Static Method
        System.out.println(stringOp(MyStringOps::staticReverse, inStr));
        // Reference to an Instance Method of a Particular Object
        System.out.println(stringOp(new MyStringOps()::nonStaticReverse, inStr));
    }
}

// (String) -> (String)
@FunctionalInterface
interface StringFunc {
    String apply(String str);
}

class MyStringOps {

    // (String) -> (String)
    public static String staticReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    // (String) -> (String)
    public String nonStaticReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

}