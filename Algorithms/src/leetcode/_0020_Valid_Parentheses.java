/**
 *  @author  Yunxiang He
 *  @date    Oct 5, 2017 12:59:36 PM
 */
package leetcode;

import java.util.Stack;

/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 */

public class _0020_Valid_Parentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.size() == 0)
                    return false;
                char _c = stack.pop();
                if (_c == '(') {
                    if (c != ')')
                        return false;
                } else if (_c == '[') {
                    if (c != ']')
                        return false;
                } else if (_c == '{') {
                    if (c != '}')
                        return false;
                }
            }

        }
        if (stack.size() > 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        _0020_Valid_Parentheses test = new _0020_Valid_Parentheses();
        System.out.println(test.isValid("[{([][][])}]"));
        System.out.println(test.isValid("{{]}}"));
        System.out.println(test.isValid(""));

    }
}
