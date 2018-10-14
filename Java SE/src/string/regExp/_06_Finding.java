package string.regExp;

import static utils.Print.*;

import java.util.regex.*;

public class _06_Finding {

    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
        while (m.find()) {
            printnb(m.group() + " ");
        }
        print();
        int i = 0;
        while (m.find(i)) {
            printnb(m.group() + " ");
            i++;
        }
    }

}