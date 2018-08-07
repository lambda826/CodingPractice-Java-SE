/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-02 00:15
 */

package containers.array;

public class _999_Sudoku {
    static int[][] game = new int[6][6];

    public static void main(String[] args) {
        game[3][3] = 6;
        Object[] obj = game;
        obj[3] = "X";
        System.out.println(game[3][3]);

    }
}
