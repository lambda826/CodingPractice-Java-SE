package leetcode;

/**
 *  @author  Yunxiang He
 *  @date    Dec 23, 2017 7:13:54 AM
 */

/*

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/

public class _0415_Add_Strings {
    public String addStrings(String num1, String num2) {
        if (num1 == "0")
            return num2;
        if (num2 == "0")
            return num1;
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int n1 = c1.length;
        int n2 = c2.length;
        int[] sum = new int[Math.max(n1, n2) + 1];
        for (int i = sum.length - 1; i >= 1; i--) {
            int k = (n1 - 1 < 0 ? 0 : c1[n1 - 1] - '0') + (n2 - 1 < 0 ? 0 : c2[n2 - 1] - '0') + sum[i];
            sum[i] = k % 10;
            sum[i - 1] = k / 10;
            n1--;
            n2--;
        }
        int i = 0;
        if (sum[0] == 0) {
            i = 1;
        }
        StringBuilder sb = new StringBuilder();
        while (i < sum.length) {
            sb.append(sum[i]);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _0415_Add_Strings().addStrings("584", "18"));
    }
}
