/**
 *  @author  Yunxiang He
 *  @date    Jan 14, 2018 7:28:30 PM
 */

package leetcode;

/*

Given a list of sorted characters letters containing only lowercase letters, 
and given a target letter target, 
find the smallest element in the list that is larger than the given target.

Letters also wrap around. 
For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.

 */

public class _0744_Find_Smallest_Letter_Greater_Than_Target {

    /**
     * Solution:
     * Binary search
     * --------------------------------------------------------------
     *  Time complexity : O(log n)
     * Space complexity : O(1)
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) {
                lo = mid + 1;
            } else if (letters[mid] > target) {
                if (mid >= 1 && letters[mid - 1] <= target) {
                    return letters[mid];
                } else if (mid - 1 < 0) {
                    return letters[mid];
                }
                hi = mid;
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
        _0744_Find_Smallest_Letter_Greater_Than_Target test = new _0744_Find_Smallest_Letter_Greater_Than_Target();
        char res = test.nextGreatestLetter(new char[] { 'b', 'c', 'c', 'c', 'c', 'd' }, 'f');
        System.out.println(res);
    }
}
