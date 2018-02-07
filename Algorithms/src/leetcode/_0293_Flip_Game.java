package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author  Yunxiang He
 *  @date    Dec 25, 2017 10:15:16 AM
 */

/*

You are playing the following Flip Game with your friend: 

Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip two consecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]

If there is no valid move, return an empty list [].

*/

public class _0293_Flip_Game {

    // corner case : s is null or of length 1;
    public List<String> generatePossibleNextMoves(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == "" || s.length() < 2)
            return res;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i) == s.charAt(i - 1)) {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i - 1, '-');
                res.add(sb.toString());
            }
        }
        return res;
    }
}
