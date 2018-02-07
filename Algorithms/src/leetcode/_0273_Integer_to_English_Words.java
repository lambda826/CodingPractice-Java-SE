/**
 *  @author  Yunxiang He
 *  @date    Dec 24, 2017 12:50:42 AM
 */

package leetcode;

/*

Convert a non-negative integer to its english words representation. 
Given input is guaranteed to be less than 2^(31 - 1).

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

*/

public class _0273_Integer_to_English_Words {

    // Corner cases : 0, 20, 100, 1000
    // Should take care of whitespace " "

    String[] tens = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] hundreds = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    StringBuilder sb = new StringBuilder();

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        while (true) {
            if (num >= 1000000000) {
                sb.append(tens[num / 1000000000]).append(" ").append("Billion ");
                num %= 1000000000;
            } else if (num >= 1000000) {
                hundredHelper(sb, num / 1000000).append("Million ");
                num %= 1000000;
            } else if (num >= 1000) {
                hundredHelper(sb, num / 1000).append("Thousand ");
                num %= 1000;
            } else {
                hundredHelper(sb, num);
                break;
            }
        }

        return sb.toString().trim();
    }

    private StringBuilder hundredHelper(StringBuilder sb, int num) {
        if (num >= 100) {
            sb.append(tens[num / 100]).append(" Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            sb.append(hundreds[num / 10]).append(" ");
            num %= 10;
        }
        if (num > 0) {
            sb.append(tens[num % 20]).append(" ");
        }
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(new _0273_Integer_to_English_Words().numberToWords(23250868));
    }
}
