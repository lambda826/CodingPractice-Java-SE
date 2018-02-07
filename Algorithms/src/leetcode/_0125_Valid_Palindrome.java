/**
 *  @author  Yunxiang He
 *  @date    Jan 22, 2018 4:00:33 PM
 */

package leetcode;

/*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

 */

public class _0125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean res = true;
        while (left < right) {
            while (left < s.length() - 1 && (s.charAt(left) < 65 || s.charAt(left) > 122)) {
                left++;
            }
            while (0 < right && (s.charAt(right) < 65 || s.charAt(right) > 122)) {
                right--;
            }
            if (left <= right && !(s.charAt(left) == s.charAt(right) || s.charAt(left) + 32 == s.charAt(right) || s.charAt(left) == s.charAt(right) + 32)) {
                res = false;
                break;
            } else {
                left++;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] argss) {
        String string = "A man, a plan, a canal: Panama";
        String string2 = ",.";
        String string3 = "race a car";
        String string4 = "  ";
        _0125_Valid_Palindrome test = new _0125_Valid_Palindrome();
        System.out.println(test.isPalindrome(string));
        System.out.println(test.isPalindrome(string2));
        System.out.println(test.isPalindrome(string3));
        System.out.println(test.isPalindrome(string4));
        System.out.println('s' - 'S');
        System.out.println('0');
        System.out.println('9');
    }

}
