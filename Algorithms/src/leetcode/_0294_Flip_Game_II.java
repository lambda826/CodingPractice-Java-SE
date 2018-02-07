/**
 *  @author  Yunxiang He
 *  @date    Dec 25, 2017 10:30:59 AM
 */

package leetcode;

import java.util.HashMap;

/*

You are playing the following Flip Game with your friend: 

Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip two consecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.

*/

public class _0294_Flip_Game_II {

    // Solution 1: backtracking + dp
    // Condition that the first player can win
    // 1. it is my turn, any one of possible moves can lead me to winning, then i win
    // 2. ti is not my turn, any one of the possible moves can lead my opponent to winning, then i lose
    // Base case: there is no available move, then the current player lose, e.i. the other one wins
    private HashMap<String, Boolean> map = new HashMap<String, Boolean>();

    public boolean canWin(String s) {
        if (s == "" || s.length() < 2)
            return false;
        canWinAux(s, true);
        return map.get(s);
    }

    private boolean canWinAux(String s, boolean isMyTurn) {
        if (map.containsKey(s))
            return map.get(s);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i) == s.charAt(i - 1)) {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i - 1, '-');
                String _s = sb.toString();

                // Always record whether I can win
                boolean whetherIcanWin = canWinAux(_s, !isMyTurn);
                if (isMyTurn) {
                    if (whetherIcanWin) {
                        map.put(s, true);
                        return true;
                    }
                } else {
                    if (!whetherIcanWin) {
                        map.put(s, false);
                        return false;
                    }
                }
            }
        }
        if (isMyTurn) {
            map.put(s, false);
        }
        return isMyTurn == true ? false : true;
    }

    // Solution 2: min-max with a-b pruning

    private HashMap<String, Integer> map2 = new HashMap<>();

    public boolean canWin2(String s) {
        if (s == "" || s.length() < 2)
            return false;
        int v = max(s, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return v == 0 ? false : true;
    }

    private int max(String s, int alfa, int beta) {
        if (!s.contains("++")) {
            map2.put(s, 0);
            return 0;
        }
        if (map2.containsKey(s)) {
            return map2.get(s);
        }
        int v = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i) == s.charAt(i - 1)) {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i - 1, '-');
                String _s = sb.toString();
                v = Math.max(v, min(_s, alfa, beta));
                if (v >= beta)
                    return v;
                alfa = Math.max(alfa, v);
            }
        }
        map2.put(s, v);
        return v;
    }

    private int min(String s, int alfa, int beta) {
        if (!s.contains("++")) {
            map2.put(s, 1);
            return 1;
        }
        if (map2.containsKey(s)) {
            return map2.get(s);
        }
        int v = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i) == s.charAt(i - 1)) {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i - 1, '-');
                String _s = sb.toString();
                v = Math.min(v, max(_s, alfa, beta));
                if (v <= alfa)
                    return v;
                beta = Math.min(beta, v);
            }
        }
        map2.put(s, v);
        return v;
    }

    public static void main(String[] args) {
        String test = "++++++++";
        System.out.println(new _0294_Flip_Game_II().canWin2(test));
        System.out.println(new _0294_Flip_Game_II().canWin(test));
    }
}
