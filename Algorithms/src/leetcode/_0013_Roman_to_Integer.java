/**
 *  @author  Yunxiang He
 *  @date    Oct 5, 2017 12:59:11 PM
 */

package leetcode;

/*

given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

罗马数字是欧洲在阿拉伯数字传入之前使用的一种数码。
罗马数字采用七个罗马字母作数字
* Ⅰ(1)
* V(5)
* X(10)
* L(50)
* C(100)
* D(500)
* M(1000)

记数的方法
* (1)相同的数字连写,所表示的数等于这些数字相加得到的数,如, Ⅲ = 3；
* (2)小的数字在大的数字的右边,所表示的数等于这些数字相加得到的数, 如,Ⅷ = 8,Ⅻ = 12；
* (3)小的数字,(限于Ⅰ、X 和 C)在大的数字的左边,所表示的数等于大数减小数得到的数,如,Ⅳ = 4,Ⅸ = 9；
* (4)在一个数的上面画一条横线,表示这个数增值 1 000 倍,如 Ⅻ = 12 000 。

罗马数字的组数规则,有几条须注意掌
* (1)基本数字Ⅰ、X 、C 中的任何一个,自身连用构成数目,或者放在大数的右边连用构成数目,都不能超过三个；放在大数的左边只能用一个。
* (2)不能把基本数字 V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；放在大数的右边采用相加的方式构成数目,只能使用一个。
* (3)V 和 X 左边的小数字只能用Ⅰ。
* (4)L 和 C 左边的小数字只能用×。
* (5)D 和 M 左 边的小数字只能用 C 。
* 
 */

public class _0013_Roman_to_Integer {

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        int curr = 0;
        int prev = 0;
        for (char c : chars) {
            switch (c) {
            case 'I':
                curr = 1;
                break;
            case 'V':
                curr = 5;
                break;
            case 'X':
                curr = 10;
                break;
            case 'L':
                curr = 50;
                break;
            case 'C':
                curr = 100;
                break;
            case 'D':
                curr = 500;
                break;
            case 'M':
                curr = 1000;
                break;

            }
            if (prev >= curr) {
                sum = prev + sum;
            } else {
                sum = -prev + sum;
            }
            prev = curr;

        }

        return sum + curr;
    }
}
