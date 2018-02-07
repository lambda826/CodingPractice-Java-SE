/**
 *  @author  Yunxiang He
 *  @date    Dec 22, 2017 4:43:47 PM
 */

package leetcode;

/*

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:
The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/

public class _0043_Multiply_Strings {

    // Multiply the digits from the tail of the String
    // The result string is at most of the sum of the lengths of the parameter string
    // Note: Every time need to sum the product and the number at the current index
    public String multiply(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int n1 = c1.length;
        int n2 = c2.length;
        int[] num = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            int x1 = c1[i] - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int x2 = c2[j] - '0';
                int k = x1 * x2 + num[i + j + 1];
                num[i + j + 1] = k % 10;
                num[i + j] += k / 10;
            }
        }
        StringBuilder sBuilder = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < num.length; i++) {
            if (flag) {
                if (num[i] != 0) {
                    flag = false;
                } else
                    continue;
            }
            sBuilder = sBuilder.append(num[i]);
        }
        return sBuilder.toString().length() == 0 ? "0" : sBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _0043_Multiply_Strings().multiply("19", "999"));
        System.out.println(999 * 19);
    }
}
