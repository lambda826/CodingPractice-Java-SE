/**
 *  @author  Yunxiang He
 *  @date    Jan 9, 2018 7:30:34 PM
 */

package leetcode;

/*

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false

 */

public class _0657_Judge_Route_Circle {
    /**
     * Solution 1:
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static boolean judgeCircle(String moves) {
        int h = 0;
        int v = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U')
                v++;
            else if (c == 'D')
                v--;
            else if (c == 'L')
                h--;
            else
                h++;
        }
        return h == 0 && v == 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UUDD"));
        System.out.println(judgeCircle("LDD"));
        System.out.println(judgeCircle("RURD"));
        System.out.println(judgeCircle("ULDR"));
    }
}