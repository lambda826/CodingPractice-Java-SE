/**
 *  @author  Yunxiang He
 *  @date    Dec 25, 2017 11:57:10 PM
 */

package leetcode;

/*

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.

*/

public class _0374_Guess_Number_Higher_or_Lower {

    private int n = 1702766719;

    private int guess(int i) {
        if (i > n)
            return -1;
        if (i == n)
            return 0;
        else
            return 1;
    }

    // Binary search
    // Caution: when compute mid: it may overflow the range of the Integer
    // mid = (low + high) / 2 = low + (high - low) / 2;
    public int guessNumber(int n) {
        return search(1, n);
    }

    private int search(int low, int high) {
        int mid = low + (high - low) / 2;
        int g = guess(mid);
        if (g == 0) {
            return mid;
        } else if (g == 1) {
            return search(mid + 1, high);
        } else {
            return search(low, mid - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _0374_Guess_Number_Higher_or_Lower().guessNumber(2126753390));
    }
}
