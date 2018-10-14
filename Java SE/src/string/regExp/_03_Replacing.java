package string.regExp;

import static utils.Print.*;

public class _03_Replacing {

    static String s = _02_Splitting.knights;

    public static void main(String[] args) {
        print(s);
        print(s.replaceFirst("f\\w+", "located"));
        print(s);
        print(s.replaceAll("shrubbery|tree|herring", "banana"));
    }

}