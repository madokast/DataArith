package zrx.com.leetcode.Q0020;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;

import java.util.List;

/**
 * Description
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * <p>
 * Data
 * 13:25
 *
 * @author zrx
 * @version 1.0
 */

public class Q0032LongestValidParentheses implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build("(()"),
                Input.InputSet.build(")()())")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(2, 4);
    }

    public class Solution0032 {
        public int longestValidParentheses(String s) {
            //TODO
            return 0;
        }
    }
}
