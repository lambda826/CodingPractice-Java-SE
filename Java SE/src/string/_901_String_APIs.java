/**

 *  @author: Yunxiang He
 *  @date  : 2018-07-11 08:58
 */

package string;

import java.util.Arrays;

public class _901_String_APIs {

    public static void main(String[] args) {

        /*********** Constructor ***********/
        // public String(char[] value)
        // public String(char[] value, int offset, int count)
        System.out.println(new String(new char[] { 'a', 'b', 'c', 'd', }));
        System.out.println(new String(new char[] { 'a', 'b', 'c', 'd', }, 0, 3));
        System.out.println(new String(new char[] { 'a', 'b', 'c', 'd', }, 1, 3));
        // offset + count 不能超过 char[].length
        // System.out.println(new String(new char[] {'a', 'b','c','d',}, 0, 5));

        String str = "This is string";
        //        String str2 = "THIS IS STRING";
        //
        //        System.out.println(str.length());
        //        System.out.println(str.toLowerCase());
        //        System.out.println(str.toUpperCase());
        //        System.out.println(str.charAt(0));
        //        System.out.println(Arrays.toString(str.toCharArray()));
        //
        //        System.out.println(str.equals(str2));
        //        System.out.println(str.equalsIgnoreCase(str2));
        //
        //        System.out.println("A".compareTo("a"));
        //        System.out.println("a".compareTo("b"));
        //
        //        System.out.println("aaa".contains("a"));
        //        System.out.println("aaa".contains("ab"));
        //

        // public boolean startsWith(String prefix)
        // public boolean startsWith(String prefix, int toffset),  toffset - where to begin looking in this string.
        // public boolean endsWith(String suffix)
        str = "abczzzzzzzzzzzzzzzzz";
        System.out.println(str.startsWith("abc"));
        System.out.println(str.startsWith("abcz", 0));
        System.out.println(str.startsWith("bcz", 1));
        System.out.println(str.endsWith("zz"));
        System.out.println(str.endsWith("zzz"));

        //        System.out.println(str.indexOf("i"));
        //        System.out.println(str.indexOf("i", 2));
        //        System.out.println(str.indexOf(97));
        //        System.out.println(str.indexOf(97, 3));
        //        System.out.println(str.lastIndexOf("s"));
        //        System.out.println(str.lastIndexOf("s", 3));
        //
        //        System.out.println(str.substring(2));
        //        System.out.println(str.substring(2, 2));
        //        System.out.println(str.substring(2, 3));
        //        System.out.println(str.subSequence(2, 3));
        //
        //        char[] chararray = { 'a', '1' };
        //        System.out.println(String.valueOf(111));
        //        System.out.println(String.valueOf(chararray));
        //
        //        System.out.println(str.replace("i", "bb"));
        //        System.out.println(str.replace('i', 'b'));
        //        System.out.println(str.replaceAll("\\w", "b"));
        //        System.out.println(str.replaceFirst("i", "bb"));
        //        System.out.println(str.replaceFirst("\\w", "b"));
        //        System.out.println(str.replaceFirst("w", "b"));
        //        System.out.println(str.matches("T"));
        //        System.out.println(str.matches("This is string"));
        //        System.out.println("This".matches("\\w+"));

        // public String[] split(String regex)
        // public String[] split(String regex, int limit),  limit - the result threshold:cut掉的regex的次数 < limit
        str = "ab|cd||ef|";
        String[] strings = str.split("|");
        String[] strings2 = str.split("|", 3);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings2));

        //        
        //        
        //        System.out.println(Arrays.toString(strings));
        //
        //        System.out.println(" a a ".trim());

        // public boolean isEmpty(),  str cannot be null, (str.length() == 0) == str.isEmpty()
        str = null;
        // System.out.println(str.isEmpty());
        System.out.println("".isEmpty());
        System.out.println(" ".isEmpty());
        System.out.println("  ".isEmpty());

        //        System.out.println(Arrays.toString(str.getBytes()));
        //
        //        char[] chs = new char[str.length()];
        //        str.getChars(0, str.length(), chs, 0);
        //        System.out.println(Arrays.toString(chs));
        //        System.out.println();
        //        System.out.println();
        //        System.out.println();
        //        System.out.println();
        //        System.out.println("ABC".startsWith("BCD", 1));

    }
}
