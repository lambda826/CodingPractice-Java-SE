package javaSe.java8.lambda;

import java.util.function.Predicate;

import javaSe.java8.common.interfaces.StringFunc;

public class _06_Method_Reference {

    static class MyStringOps {

        // StringFunc: (String) -> (String)
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

    static class _07_MethodReference2 {

        public static int check(Predicate<Student> p, Student i) {
            return p.test(i) ? 1 : 0;
        }

        public static void main(String args[]) {
            Student student = new Student(20);
        }
    }

    static class Student {
        int num;

        public Student(int num) {
            this.num = num;
        }

        public boolean isGreater(int i) {
            return num > i;
        }
    }

}
