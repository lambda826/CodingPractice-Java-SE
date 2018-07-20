/**

 *  @author: Yunxiang He
 *  @date  : 2018-07-11 08:58
 */

package string;

import java.util.Arrays;

public class _901_String_APIs {

    public static void main(String[] args) {
        String str1 = "This is string";
        String str2 = "THIS IS STRING";

        System.out.println(str1.length());
        System.out.println(str1.toLowerCase());
        System.out.println(str1.toUpperCase());
        System.out.println(str1.charAt(0));
        System.out.println(Arrays.toString(str1.toCharArray()));

        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println("A".compareTo("a"));
        System.out.println("a".compareTo("b"));

        System.out.println("aaa".contains("a"));
        System.out.println("aaa".contains("ab"));

        System.out.println(str1.startsWith("T"));
        System.out.println(str1.startsWith("t"));
        System.out.println(str1.startsWith("i", 3));
        System.out.println(str1.endsWith("i"));
        System.out.println(str1.endsWith("g"));

        System.out.println(str1.indexOf("i"));
        System.out.println(str1.indexOf("i", 2));
        System.out.println(str1.indexOf(97));
        System.out.println(str1.indexOf(97, 3));
        System.out.println(str1.lastIndexOf("s"));
        System.out.println(str1.lastIndexOf("s", 3));

        System.out.println(str1.substring(2));
        System.out.println(str1.substring(2, 2));
        System.out.println(str1.substring(2, 3));
        System.out.println(str1.subSequence(2, 3));

        char[] chararray = { 'a', '1' };
        System.out.println(String.valueOf(111));
        System.out.println(String.valueOf(chararray));

        System.out.println(str1.replace("i", "bb"));
        System.out.println(str1.replace('i', 'b'));
        System.out.println(str1.replaceAll("\\w", "b"));
        System.out.println(str1.replaceFirst("i", "bb"));
        System.out.println(str1.replaceFirst("\\w", "b"));
        System.out.println(str1.replaceFirst("w", "b"));
        System.out.println(str1.matches("T"));
        System.out.println(str1.matches("This is string"));
        System.out.println("This".matches("\\w+"));

        String[] strings = str1.split(" ");
        System.out.println(Arrays.toString(strings));

        System.out.println(" a a ".trim());

        System.out.println("".isEmpty());
        System.out.println("  ".isEmpty());

        System.out.println(Arrays.toString(str1.getBytes()));

        char[] chs = new char[str1.length()];
        str1.getChars(0, str1.length(), chs, 0);
        System.out.println(Arrays.toString(chs));
    }
}
