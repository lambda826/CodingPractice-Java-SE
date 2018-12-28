/**
 *  @author Yunxiang He
 *  @date   12/27/2018
 */

package autoBoxing;

public class CharacterDemo {

    public static void main(String[] args) {
        Character c = 99;
        System.out.println(c.charValue());
        System.out.println(Character.digit('d', 10));
        System.out.println(Character.digit(97, 16));
        System.out.println(Character.getNumericValue('9'));
        System.out.println(Character.isAlphabetic('a'));
        System.out.println(Character.isDigit('a'));
    }
}
