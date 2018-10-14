package string;

import static utils.Print.print;

public class _101_Immutable {

    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        print(q);
        String qq = upcase(q);
        print(qq);
        print(q);
    }

}