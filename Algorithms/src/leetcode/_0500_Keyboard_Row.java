/**
 *  @author  Yunxiang He
 *  @date    Jan 12, 2018 9:52:39 PM
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*

Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


American keyboard


Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]

Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.

 */

public class _0500_Keyboard_Row {
    public String[] findWords(String[] words) {
        String[] rows = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
        String[] returnArr = new String[words.length];
        int i;
        int j;
        int k;
        int l;
        boolean charFlag;
        boolean rowFlag;
        int row;
        for (i = 0; i < words.length; i++) {
            row = -1;
            rowFlag = false;
            charFlag = false;
            char[] cArr = words[i].toCharArray();
            for (j = 0; j < cArr.length; j++) {
                char currentChar = cArr[j];
                // find out which row to check based on initial character
                if (j == 0) {
                    for (k = 0; k < rows.length; k++) {
                        char[] workingRow = rows[k].toCharArray();
                        for (l = 0; l < workingRow.length; l++) {
                            if (currentChar == workingRow[l] || (char) (currentChar + 32) == workingRow[l]) {
                                rowFlag = true;
                                row = k;
                                break;
                            }
                        }
                        if (rowFlag) {
                            break;
                        }
                    }
                }
                if (!rowFlag) {
                    break;
                }
                // After establishing row, check to see if other characters are
                // in it
                else {
                    charFlag = false;
                    char[] workingRow = rows[row].toCharArray();
                    for (l = 0; l < workingRow.length; l++) {
                        if (currentChar == workingRow[l] || (char) (currentChar + 32) == workingRow[l]) {
                            charFlag = true;
                            break;
                        }
                    }
                    if (!charFlag) {
                        break;
                    }
                }

            }
            if (charFlag && rowFlag) {
                returnArr[i] = words[i];
            }
        }
        ArrayList<String> list = new ArrayList<>();
        int counter;
        for (counter = 0; counter < returnArr.length; counter++) {
            if (returnArr[counter] != null) {
                list.add(returnArr[counter]);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] solution2(String[] words) {
        List<String> resList = new ArrayList<>();
        List<Character> l1 = Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        List<Character> l2 = Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        List<Character> l3 = Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm');

        outter: for (String str : words) {
            boolean b1 = true;
            boolean b2 = true;
            boolean b3 = true;
            for (char c : str.toLowerCase().toCharArray()) {
                if (b1 && l1.contains(c)) {
                    b2 = false;
                    b3 = false;
                } else if (b2 && l2.contains(c)) {
                    b1 = false;
                    b3 = false;
                } else if (b3 && l3.contains(c)) {
                    b1 = false;
                    b2 = false;
                } else {
                    continue outter;
                }
            }
            resList.add(str);
        }
        return resList.toArray(new String[resList.size()]);
    }

    public String[] solution3(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }

    public static void main(String[] args) {
        _0500_Keyboard_Row test = new _0500_Keyboard_Row();
        test.findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" });
    }
}
